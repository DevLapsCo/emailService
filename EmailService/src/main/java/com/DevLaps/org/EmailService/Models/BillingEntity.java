package com.DevLaps.org.EmailService.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Billings")
public class BillingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    private String InvoiceID;
    private String Bill;
    private boolean paid;

}
