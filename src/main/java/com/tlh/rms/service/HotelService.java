package com.tlh.rms.service;

import com.tlh.rms.data.entities.HotelEntity;

import java.util.List;

public interface HotelService {

    /**
     *
     * @return all the hotels in the chain
     * @throws com.tlh.rms.common.error.ServiceException if empty.
     */
    List<HotelEntity> getHotelList();
}
