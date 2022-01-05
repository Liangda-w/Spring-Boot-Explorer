package edu.tum.ase.project.controller;

import edu.tum.ase.project.model.Project;
import edu.tum.ase.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    
    @Autowired
    ProjectService projectService;
    
    @GetMapping
    public List<Project> getAllProject() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{name}")
    @ResponseBody
    public Project getProjectByName(@PathVariable String name) throws Exception {
        return projectService.findByName(name);
    }

    @GetMapping("/get")
    @ResponseBody
    public Project getByName(@RequestParam String name) throws Exception{
        return projectService.findByName(name);
    }

    @PostMapping("/create")
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }
}
