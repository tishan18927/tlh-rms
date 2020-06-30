package com.tlh.rms.service.impl;

import com.tlh.rms.common.error.ErrorType;
import com.tlh.rms.common.error.ServiceException;
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
        Set<RoomEntity> availableRooms = roomRepository.findAllAvailable(hotelId, endDate, startingDate, personCount);

        if (Objects.isNull(availableRooms) || availableRooms.isEmpty()) {
            throw new ServiceException(ErrorType.NO_ROOMS_AVAILABLE);
        }

        return availableRooms;
    }

    @Override
    public RoomEntity checkRoomAvailability(ReservationRepresentation representation) {
        return checkRoomAvailability(
                representation.getRoom().getId(),
                representation.getFrom(),
                representation.getTo()
        );
    }

    @Override
    public RoomEntity checkRoomAvailability(Long id, Date startingDate, Date endDate) {
        RoomEntity available = roomRepository.getAvailabilityForRoom(id, endDate, startingDate);

        if (Objects.isNull(available)) {
            throw new ServiceException(ErrorType.ROOM_ALREADY_TAKEN);
        }
        return available;
    }
}
