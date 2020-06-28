package com.tlh.rms.controller;

import com.tlh.rms.data.entities.RoomEntity;
import com.tlh.rms.representation.RoomSearchRequest;
import com.tlh.rms.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping(path = "/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping(path = "/availability")
    public Set<RoomEntity> serachAvailability(@Valid @RequestBody RoomSearchRequest request) {
        return roomService.availabilitySearch(request.getHotel(), request.getFromDate(), request.getToDate(), request.getPersonCount());
    }
}
