package com.DevLaps.org.EmailService.Models;


import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Invoice")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    private String ProjectId;
    private String Service;
    private String Bill;
    private String SpecialMessage;
    private boolean confirmed;

}


