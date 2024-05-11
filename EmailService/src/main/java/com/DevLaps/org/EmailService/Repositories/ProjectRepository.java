package com.DevLaps.org.EmailService.Repositories;

import com.DevLaps.org.EmailService.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {
    Project getReferenceByName(String name);
}
