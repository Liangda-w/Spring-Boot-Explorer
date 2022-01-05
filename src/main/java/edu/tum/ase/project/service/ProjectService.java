package edu.tum.ase.project.service;

import edu.tum.ase.project.model.Project;
import edu.tum.ase.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project) {
        // TODO: implement
        projectRepository.save(project);
        return project;
    }

    public Project findByName(String name) throws Exception{
        // TODO: implement
        return projectRepository.findByName(name).orElseThrow(() -> new Exception("No project exists wih name" + name));
    }

    public List<Project> getAllProjects() {
        // TODO: implement
        return projectRepository.findAll();
    }
}
