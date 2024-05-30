package com.DevLaps.org.EmailService.Repositories;

import com.DevLaps.org.EmailService.Models.QuickBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuickBillRepository extends JpaRepository<QuickBill, UUID> {
}
