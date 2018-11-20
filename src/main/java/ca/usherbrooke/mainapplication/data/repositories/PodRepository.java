package ca.usherbrooke.mainapplication.data.repositories;

import javax.transaction.Transactional;

import ca.usherbrooke.mainapplication.data.GenericRepository;
import ca.usherbrooke.mainapplication.data.entities.Pod;

@Transactional
public interface PodRepository extends GenericRepository<Pod, String>{

}
