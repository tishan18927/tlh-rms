package com.tlh.rms.util;

import com.tlh.rms.billing.representation.PaymentRepresentation;
import com.tlh.rms.data.entities.ReservationEntity;
import com.tlh.rms.representation.ReservationRepresentation;

public class EntityToRepConverter {

    public static ReservationRepresentation convertToResourceRep(ReservationEntity entity) {
        ReservationRepresentation rep = new ReservationRepresentation();
        rep.setRoom(entity.getRoom());
        rep.setFrom(entity.getFirstDate());
        rep.setTo(entity.getLastDate());
        return rep;
    }

    public static ReservationRepresentation convertToResourceRep(ReservationEntity entity, PaymentRepresentation payment) {
        ReservationRepresentation rep = convertToResourceRep(entity);
        rep.setPayment(payment);
        return rep;
    }
}
