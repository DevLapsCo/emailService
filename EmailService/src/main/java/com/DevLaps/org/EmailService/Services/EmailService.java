package com.DevLaps.org.EmailService.Services;


public interface EmailService {
    void sendHtmlNewProjectEmail(String email, String owner, String project, String projecttype);
    void sendQuickBillEmail(String email, String billing_to,String purpose, String bill, String url);
}
