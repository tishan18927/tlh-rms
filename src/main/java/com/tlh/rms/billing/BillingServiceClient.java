package com.tlh.rms.billing;

import com.tlh.rms.billing.representation.Payment;
import com.tlh.rms.billing.representation.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "bm-service-client",
        url = "${serviceurls.billing:http://localhost:8440}"
)
public interface BillingServiceClient {

    @PostMapping(path = "billing/charge/reservation")
    Payment makeReservation(@RequestBody Payment<Reservation> payment);
}
