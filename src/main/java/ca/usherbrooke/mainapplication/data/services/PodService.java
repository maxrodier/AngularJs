package ca.usherbrooke.mainapplication.data.services;

import org.springframework.stereotype.Service;

import ca.usherbrooke.mainapplication.data.GenericRepository;
import ca.usherbrooke.mainapplication.data.GenericService;
import ca.usherbrooke.mainapplication.data.entities.Pod;
import ca.usherbrooke.mainapplication.data.repositories.PodRepository;

@Service
public class PodService implements GenericService<Pod, String> {

	private final PodRepository podRepository;
	
	public PodService(final PodRepository podRepository) {
		this.podRepository = podRepository;
	}
	
	@Override
	public String getId(Pod entity) {
		return entity.getNamePod();
	}

	@Override
	public GenericRepository<Pod, String> getRepository() {
		return podRepository;
	}
}