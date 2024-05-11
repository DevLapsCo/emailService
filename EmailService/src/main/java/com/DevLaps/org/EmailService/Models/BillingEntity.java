package com.DevLaps.org.EmailService.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table( name = "Billings")
public class BillingEntity {

   private UUID Id;
   private String InvoiceID;
   private String Bill;
   private boolean paid;

}
