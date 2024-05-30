package com.DevLaps.org.EmailService.Services;

import com.DevLaps.org.EmailService.Models.QuickBill;
import com.DevLaps.org.EmailService.Params.Id;
import com.DevLaps.org.EmailService.Params.PaymentBody;
import com.DevLaps.org.EmailService.Params.VerifyPayment;
import com.DevLaps.org.EmailService.Repositories.QuickBillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

import static com.DevLaps.org.EmailService.Utils.EmailUtils.getBillUrl;
@Service
public class QuickBllingService {

    private final QuickBillRepository quickBillRepository;

    private final EmailServiceImpl emailService;

    private final WebClient webClient;

    private final String secretKey = "sk_live_019c9b7ca68386be4cfbb3359db78546761adae5";

    public QuickBill addBill(QuickBill newbill){
        QuickBill bill = quickBillRepository.save(newbill);
        emailService.sendQuickBillEmail(bill.getEmail(), bill.getBilling_to(), bill.getPurpose(), String.valueOf(bill.getBill()), getBillUrl("http://billing.devlaps.co", String.valueOf(bill.getId())));
        return bill;
    }

    public Optional<QuickBill> getBill(String id){
        return quickBillRepository.findById(UUID.fromString(id));
    }


    public QuickBllingService(QuickBillRepository quickBillRepository, EmailServiceImpl emailService, WebClient.Builder webClientBuilder) {
        this.quickBillRepository = quickBillRepository;
        this.emailService = emailService;
        this.webClient = webClientBuilder.baseUrl("https://api.paystack.co")
                .defaultHeader("Authorization", "Bearer " + secretKey)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    public Mono<String> initializeTransaction(PaymentBody paymentBody) {
        return webClient.post()
                .uri("/transaction/initialize")
                .body(BodyInserters.fromValue(paymentBody))
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> verifyTransaction(String reference) {
        return webClient.get()
                .uri("/transaction/verify/" + reference)
                .retrieve()
                .bodyToMono(String.class);
    }

}
