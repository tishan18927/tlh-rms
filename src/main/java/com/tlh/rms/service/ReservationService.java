package com.tlh.rms.service;

import com.tlh.rms.representation.ReservationRepresentation;

public interface ReservationService {

    /**
     * Makes the reservation.
     * Make sure that there is no conflicts in payment and reservation.
     * @param reservationRepresentation reservation request
     * @return reservation representation back.
     */
    ReservationRepresentation makeReservation(ReservationRepresentation reservationRepresentation);
}
