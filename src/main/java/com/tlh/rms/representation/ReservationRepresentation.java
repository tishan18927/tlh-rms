package com.tlh.rms.representation;

import com.tlh.rms.billing.representation.PaymentRepresentation;
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
    private PaymentRepresentation payment;

    @NotNull(message = "Please specify checking-in date!")
    private Date from;

    @NotNull(message = "Please specify check-out date!")
    private Date to;
}
