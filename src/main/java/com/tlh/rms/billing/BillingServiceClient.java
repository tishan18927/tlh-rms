package com.tlh.rms.billing;

import com.tlh.rms.billing.representation.PaymentRepresentation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "bm-service-client",
        url = "http://123",
        fallback = BillingServiceFallback.class
)
public interface BillingServiceClient {

    @PostMapping(path = "billing/reservation/charge")
    PaymentRepresentation makeReservation(@RequestBody PaymentRepresentation payment);
}
