package com.tlh.rms.service.impl;

import com.tlh.rms.billing.BillingServiceClient;
import com.tlh.rms.billing.representation.PaymentRepresentation;
import com.tlh.rms.data.ReservationRepository;
import com.tlh.rms.data.entities.ReservationEntity;
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
        entity.setRoom(roomService.checkRoomAvailability(reservationRepresentation));
        ReservationEntity saved = reservationRepository.save(entity);
        PaymentRepresentation payment = billingServiceClient.makeReservation(reservationRepresentation.getPayment());
        return EntityToRepConverter.convertToResourceRep(saved, payment);
    }
}
