package com.tlh.rms.billing;

import com.tlh.rms.billing.representation.PaymentRepresentation;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class BillingServiceFallback implements BillingServiceClient {

    @Override
    public PaymentRepresentation makeReservation(PaymentRepresentation payment) {
        //throw new RuntimeException();
        return new PaymentRepresentation();
    }
}
