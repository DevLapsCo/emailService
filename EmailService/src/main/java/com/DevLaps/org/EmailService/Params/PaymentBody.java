package com.DevLaps.org.EmailService.Params;

public record PaymentBody (String email, String amount, String currency, String callback_url) {
}
