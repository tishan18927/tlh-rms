package com.tlh.rms.service;

import com.tlh.rms.data.entities.RoomEntity;
import com.tlh.rms.representation.ReservationRepresentation;

import java.util.Date;
import java.util.Set;

public interface RoomService {

    /**
     *
     * @param hotelId selected hotel
     * @param startingDate checking-in date
     * @param endDate check-out date
     * @param personCount number of people
     * @return available rooms in the hotel, empty list if no rooms available
     */
    Set<RoomEntity> availabilitySearch(Long hotelId, Date startingDate, Date endDate, int personCount);

    /**
     *
     * @param id selected room id.
     * @param startingDate checking-in date.
     * @param endDate checkout date
     * @return entity representation for room
     * roomRepository.findAllAvailable(hotelId, endDate, startingDate, personCount);
     */
    RoomEntity checkRoomAvailability(Long id,  Date startingDate, Date endDate);

    /**
     * check room availability using reservation representation.
     * Same as @Code<checkRoomAvailability(Long id,  Date startingDate, Date endDate)></checkRoomAvailability(Long>
     */
    RoomEntity checkRoomAvailability(ReservationRepresentation representation);
}
