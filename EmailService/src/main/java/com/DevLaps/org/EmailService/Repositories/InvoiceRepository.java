package com.DevLaps.org.EmailService.Repositories;

import com.DevLaps.org.EmailService.Models.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, UUID> {
}
