package com.tlh.rms.billing.representation;

import com.tlh.rms.common.constants.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Payment<T> {

    @Valid
    private T references;

    private Integer rowVersion;

    @NotBlank(message = "PaymentToken is blank.")
    private String paymentToken;

    @NotNull(message = "PaymentType is blank.")
    private PaymentType paymentType;

    private Long amount;

    @NotNull(message = "Reference is null.")
    private Long refId;

    private String createdBy;

    private Long createdAt;

}
