package com.DevLaps.org.EmailService.Repositories;

import com.DevLaps.org.EmailService.Models.BillingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BillingRepository extends JpaRepository<BillingEntity, UUID> {
}
