package com.jbcode.fraud.controller;

import com.jbcode.fraud.model.FraudCheckHistory;
import com.jbcode.fraud.record.FraudCheckResponse;
import com.jbcode.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("customerId") Integer customerId) {
        boolean isFraudulentCustomer = fraudCheckService.
                isFraudulentCustomer(customerId);
        log.info("fraud check request for customer {}", customerId);

        return new FraudCheckResponse(isFraudulentCustomer);
    }
    @GetMapping("/getall")
    public List<FraudCheckHistory> getAll() {
        List<FraudCheckHistory> isFraudulentCustomer = fraudCheckService.
                getAllFrauders();
        return isFraudulentCustomer;
    }
}
