package com.tlh.rms.service.impl;

import com.tlh.rms.data.HotelRepository;
import com.tlh.rms.data.entities.HotelEntity;
import com.tlh.rms.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<HotelEntity> getHotelList() {
        return hotelRepository.findAll();
    }
}
