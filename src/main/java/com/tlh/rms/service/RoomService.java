package com.tlh.rms.service;

import com.tlh.rms.data.entities.RoomEntity;
import com.tlh.rms.representation.ReservationRepresentation;

import java.util.Date;
import java.util.Set;

public interface RoomService {

    Set<RoomEntity> availabilitySearch(Long hotelId, Date startingDate, Date endDate, int personCount);

    RoomEntity checkRoomAvailability(Long id, Long hotelId, Date startingDate, Date endDate);

    RoomEntity checkRoomAvailability(ReservationRepresentation representation);
}
