package com.tlh.rms.service.impl;

import com.tlh.rms.billing.BillingServiceClient;
import com.tlh.rms.billing.representation.Payment;
import com.tlh.rms.billing.representation.Reservation;
import com.tlh.rms.common.constants.PaymentType;
import com.tlh.rms.data.ReservationRepository;
import com.tlh.rms.data.entities.ReservationEntity;
import com.tlh.rms.data.entities.RoomEntity;
import com.tlh.rms.representation.ReservationRepresentation;
import com.tlh.rms.service.ReservationService;
import com.tlh.rms.service.RoomService;
import com.tlh.rms.util.EntityToRepConverter;
import com.tlh.rms.util.RepresentationToEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomService roomService;

    @Autowired
    private BillingServiceClient billingServiceClient;

    @Transactional
    @Override
    public ReservationRepresentation makeReservation(ReservationRepresentation reservationRepresentation) {
        ReservationEntity entity = RepresentationToEntityConverter.convertToReservationEntity(reservationRepresentation);
        // Check availability again on reservation for verification
        RoomEntity reservingRoom = roomService.checkRoomAvailability(reservationRepresentation);
        entity.setRoom(reservingRoom);
        ReservationEntity saved = reservationRepository.save(entity);

        Payment paymentRep = reservationRepresentation.getPayment();
        Reservation reservation = new Reservation(reservingRoom.getHotel().getId(), reservingRoom.getCategory().getId());
        paymentRep.setReferences(reservation);
        paymentRep.setRefId(saved.getId());
        paymentRep.setPaymentType(PaymentType.RESERVATION);
        Payment payment = billingServiceClient.makeReservation(paymentRep);
        return EntityToRepConverter.convertToResourceRep(saved, payment);
    }
}
