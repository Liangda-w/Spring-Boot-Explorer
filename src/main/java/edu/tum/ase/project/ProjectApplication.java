package edu.tum.ase.project;

import com.mongodb.client.MongoClient;
import edu.tum.ase.project.model.Project;
import edu.tum.ase.project.repository.ProjectRepository;
import edu.tum.ase.project.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {ProjectRepository.class})
public class ProjectApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ProjectApplication.class);

	@Autowired
	MongoClient mongoClient;
	
	@Autowired
	ProjectService projectService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("MongoClient = " + mongoClient.getClusterDescription());
		/*
		String projectName = "1";

		Project project = projectService.createProject(new Project(projectName));

		log.info(String.format("Project %s is created with id %s",
				project.getName(),
				project.getId()));

		Project aseDeliveryProject = projectService.findByName("1");

		log.info(String.format("Found Project %s with id %s",
				aseDeliveryProject.getName(),
				aseDeliveryProject.getId()));
*/
		List<Project> projectList = projectService.getAllProjects();
		log.info("Number of Project in Database is " + projectList.size());
		
		for (Project p : projectList) {
			log.info("Project: " + p.getName());
		}
	}
}
