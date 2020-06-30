package com.tlh.rms.billing.representation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @NotNull(message = "Hotel is null.")
    private Long hotel;

    @NotNull(message = "Room Category is null.")
    private Long category;
}
