package com.DevLaps.org.EmailService.Controllers;

import com.DevLaps.org.EmailService.Models.QuickBill;
import com.DevLaps.org.EmailService.Params.Id;
import com.DevLaps.org.EmailService.Params.PaymentBody;
import com.DevLaps.org.EmailService.Params.VerifyPayment;
import com.DevLaps.org.EmailService.Services.QuickBllingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/quick-bill")
public class QuickBillController {

    private final QuickBllingService quickBllingService;

    @PostMapping("/")
    public ResponseEntity<QuickBill> addBill(@RequestBody QuickBill bill){
        return ResponseEntity.ok(quickBllingService.addBill(bill));
    }
    @PostMapping("/getData")
    public ResponseEntity<Optional<QuickBill>> getBill(@RequestBody String id){
        return ResponseEntity.ok(quickBllingService.getBill(id));
    }

    @PostMapping("/init-payment")
    public ResponseEntity<Mono<String>> initializePayment(@RequestBody PaymentBody paymentBody){
        return ResponseEntity.ok(quickBllingService.initializeTransaction(paymentBody));
    }

    @PostMapping("/verify-payment")
    public ResponseEntity<Mono<String>> verifyPayment(@RequestBody String reference){
        return ResponseEntity.ok(quickBllingService.verifyTransaction(reference));
    }
}
