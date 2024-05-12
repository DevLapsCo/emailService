package com.DevLaps.org.EmailService.Services;

import com.DevLaps.org.EmailService.Models.Project;
import com.DevLaps.org.EmailService.Repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectService {

    public final ProjectRepository projectRepository;

    public final EmailServiceImpl emailService;

    public Project addProject(Project projectBody){
        emailService.sendHtmlNewProjectEmail(projectBody.getOwnerEmail(), projectBody.getOwner(), projectBody.getProjectName(), projectBody.getProjectType());
        return projectRepository.save(Project
                .builder()
                        .CompanyName(projectBody.getCompanyName())
                        .ProjectName(projectBody.getProjectName())
                        .CompanyEmail(projectBody.getCompanyEmail())
                        .ProjectType(projectBody.getProjectType())
                        .Goal(projectBody.getGoal())
                        .Description(projectBody.getDescription())
                        .Owner(projectBody.getOwner())
                        .OwnerEmail(projectBody.getOwnerEmail())
                        .Contact(projectBody.getContact())
                        .confirmed(false)
                .build());
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(UUID id) {
       return projectRepository.getReferenceById(id);
    }

//    public Project getProjectByName(String ProjectName){
//        return projectRepository.getReferenceByName(ProjectName);
//    }

    public void updateProject(UUID id, Project newProjectDetails){
        Optional<Project> existingProject = projectRepository.findById(id);

        if(existingProject.isPresent()){
        var updatedProject = existingProject.get();
        updatedProject.setProjectName(newProjectDetails.getProjectName());
        updatedProject.setProjectType(newProjectDetails.getProjectType());
        updatedProject.setGoal(newProjectDetails.getGoal());
        updatedProject.setCompanyName(newProjectDetails.getCompanyName());
        updatedProject.setDescription(newProjectDetails.getDescription());
        updatedProject.setOwner(newProjectDetails.getOwner());
              projectRepository.save(updatedProject);
        }
    }

    public void deleteProject(UUID id){
        projectRepository.deleteById(id);
    }
}
