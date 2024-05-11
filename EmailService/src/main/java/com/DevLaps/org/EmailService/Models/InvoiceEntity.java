package com.DevLaps.org.EmailService.Models;


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
    private Services[] Service;
    private String Bill;
    private String SpecialMessage;
    private boolean confirmed;

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
class Services{

    private String ServiceName;
    private String description;
    private String Price;

}