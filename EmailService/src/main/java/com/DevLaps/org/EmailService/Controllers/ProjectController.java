package com.DevLaps.org.EmailService.Controllers;

import com.DevLaps.org.EmailService.Models.Project;
import com.DevLaps.org.EmailService.Services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/project")
@RestController
public class ProjectController {

    public final ProjectService projectService;

    @PostMapping("/")
    public ResponseEntity<Project> addProject(@RequestBody Project project){
        return ResponseEntity.ok(projectService.addProject(project));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Project>> getAllProjects(){
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable UUID Id){
        return projectService.getProjectById(Id);
    }
//    @GetMapping("/{name}")
//    public Project getProjectById(@RequestParam String name){
//        return projectService.getProjectByName(name);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProject(@PathVariable UUID id, @RequestBody Project projectBody){
        projectService.updateProject(id, projectBody);
        return ResponseEntity.ok("Successfully Updated!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@RequestParam UUID id){
        projectService.deleteProject(id);
        return ResponseEntity.ok("Successfully Deleted Project!");
    }



}
