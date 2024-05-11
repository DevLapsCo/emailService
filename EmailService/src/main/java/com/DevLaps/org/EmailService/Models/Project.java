package com.DevLaps.org.EmailService.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table( name = "Projects")
public class Project {

    private UUID Id;
    private String ProjectName;
    private String ProjectType;
    private String Owner;
    private String CompanyName;
    private String Description;
    private String Goal;
    private String CompanyEmail;
    private String OwnerEmail;
    private String Contact;
    private String confirmed;

}
