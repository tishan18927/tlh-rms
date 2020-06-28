package com.tlh.rms.service.impl;

import com.tlh.rms.data.RoomRepository;
import com.tlh.rms.data.entities.RoomEntity;
import com.tlh.rms.representation.ReservationRepresentation;
import com.tlh.rms.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Set<RoomEntity> availabilitySearch(Long hotelId, Date startingDate, Date endDate, int personCount) {
        return roomRepository.findAllAvailable(hotelId, endDate, startingDate, personCount);
    }

    @Override
    public RoomEntity checkRoomAvailability(ReservationRepresentation representation) {
        return checkRoomAvailability(
                representation.getRoom().getId(),
                representation.getHotelId(),
                representation.getFrom(),
                representation.getTo()
        );
    }

    @Override
    public RoomEntity checkRoomAvailability(Long id, Long hotelId, Date startingDate, Date endDate) {
        RoomEntity available = roomRepository.getAvailabilityForRoom(id, endDate, startingDate);

        if (Objects.isNull(available)) {
            throw new RuntimeException("Room Unavailable. Please select another.");
        }
        return available;
    }
}
