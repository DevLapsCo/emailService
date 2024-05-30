package com.DevLaps.org.EmailService.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuickBill {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int bill;
    private String purpose;
    private String billing_to;
    private String email;

}
