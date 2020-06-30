package com.tlh.rms.representation;

import com.tlh.rms.billing.representation.Payment;
import com.tlh.rms.billing.representation.Reservation;
import com.tlh.rms.data.entities.RoomEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class ReservationRepresentation {

    private Long id;

    private Long hotelId;

    @NotNull(message = "Please specify room!")
    private RoomEntity room;

    @NotNull(message = "Please add payment details!")
    private Payment<Reservation> payment;

    @NotNull(message = "Please specify checking-in date!")
    private Date from;

    @NotNull(message = "Please specify checking-out date!")
    private Date to;
}
