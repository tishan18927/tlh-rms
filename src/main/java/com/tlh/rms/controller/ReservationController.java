package com.tlh.rms.controller;

import com.tlh.rms.representation.ReservationRepresentation;
import com.tlh.rms.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping(path = "/reserve")
    public ReservationRepresentation reserveRoom(@Valid @RequestBody ReservationRepresentation representation) {
        return reservationService.makeReservation(representation);
    }
}
