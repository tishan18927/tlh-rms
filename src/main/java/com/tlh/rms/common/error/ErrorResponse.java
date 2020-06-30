package com.tlh.rms.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String path = "";
    private String code;
    private String message;
    private String details;
    private Long timestamp;
}
