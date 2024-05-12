package com.DevLaps.org.EmailService.Repositories;

import com.DevLaps.org.EmailService.Models.BillingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BillingRepository extends JpaRepository<BillingEntity, UUID> {
}
