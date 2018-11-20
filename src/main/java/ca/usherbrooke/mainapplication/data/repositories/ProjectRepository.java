package ca.usherbrooke.mainapplication.data.repositories;

import javax.transaction.Transactional;

import ca.usherbrooke.mainapplication.data.GenericRepository;
import ca.usherbrooke.mainapplication.data.entities.Project;

@Transactional
public interface ProjectRepository extends GenericRepository<Project, String>{

}
