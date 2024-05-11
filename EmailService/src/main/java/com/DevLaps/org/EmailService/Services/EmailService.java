package com.DevLaps.org.EmailService.Services;

import com.DevLaps.org.EmailService.Models.InvoiceEntity;
import com.DevLaps.org.EmailService.Models.Project;

public interface EmailService {
    void sendHtmlNewProjectEmail(Project projectData);
}
