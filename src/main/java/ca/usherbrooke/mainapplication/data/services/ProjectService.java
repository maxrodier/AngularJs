package ca.usherbrooke.mainapplication.data.services;

import org.springframework.stereotype.Service;

import ca.usherbrooke.mainapplication.data.GenericRepository;
import ca.usherbrooke.mainapplication.data.GenericService;
import ca.usherbrooke.mainapplication.data.entities.Project;
import ca.usherbrooke.mainapplication.data.repositories.ProjectRepository;

@Service
public class ProjectService implements GenericService<Project, String>{

	private final ProjectRepository projectRepository;
	
	public ProjectService(final ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	@Override
	public String getId(Project entity) {
		return entity.getNameProject();
	}

	@Override
	public GenericRepository<Project, String> getRepository() {
		return projectRepository;
	}
}
