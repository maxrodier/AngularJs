package ca.usherbrooke.mainapplication.data.services;

import org.springframework.stereotype.Service;

import ca.usherbrooke.mainapplication.data.GenericRepository;
import ca.usherbrooke.mainapplication.data.GenericService;
import ca.usherbrooke.mainapplication.data.entities.User;
import ca.usherbrooke.mainapplication.data.repositories.UserRepository;

@Service
public class UserService implements GenericService<User, String>{

	private final UserRepository userRepository;
	
	public UserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public String getId(User entity) {
		return entity.getUsername();
	}

	@Override
	public GenericRepository<User, String> getRepository() {
		return userRepository;
	}
}
