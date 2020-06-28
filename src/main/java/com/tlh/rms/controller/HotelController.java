package com.tlh.rms.controller;

import com.tlh.rms.data.entities.HotelEntity;
import com.tlh.rms.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping(path = "/get-all")
    public List<HotelEntity> getAllHotels() {
        return hotelService.getHotelList();
    }
}
