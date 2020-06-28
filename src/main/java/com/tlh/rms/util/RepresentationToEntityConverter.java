package com.tlh.rms.util;

import com.tlh.rms.data.entities.ReservationEntity;
import com.tlh.rms.representation.ReservationRepresentation;

public class RepresentationToEntityConverter {

    public static ReservationEntity convertToReservationEntity(ReservationRepresentation representation) {
        ReservationEntity entity = new ReservationEntity();

        entity.setReservedBy("test-user");
        entity.setFirstDate(representation.getFrom());
        entity.setLastDate(representation.getTo());

        return entity;
    }
}
