package com.DevLaps.org.EmailService.Services;

import com.DevLaps.org.EmailService.Models.BillingEntity;
import com.DevLaps.org.EmailService.Models.Project;
import com.DevLaps.org.EmailService.Repositories.BillingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BillingService {

    public final BillingRepository billingRepository;

    public BillingEntity addBilling(BillingEntity bill){
        return billingRepository.save(bill);
    }

    public void updateBill(UUID id, BillingEntity updatedBill){
        Optional<BillingEntity> existingBill = billingRepository.findById(id);

        if(existingBill.isPresent()){
            var updatedProject = existingBill.get();
            updatedProject.setInvoiceID(updatedBill.getInvoiceID());
            updatedProject.setBill(updatedBill.getBill());
            updatedProject.setPaid(updatedBill.isPaid());
            billingRepository.save(updatedProject);
        }
    }

}
