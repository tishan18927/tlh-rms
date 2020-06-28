package com.tlh.rms.representation;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class RoomSearchRequest {
    @NotNull(message = "Hotel is not specified.")
    private Long hotel;

    @NotNull(message = "From date is required.")
    private Date fromDate;

    @NotNull(message = "To date is required.")
    private Date toDate;

    private int personCount = 1;
}
