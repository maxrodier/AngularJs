package ca.usherbrooke.mainapplication.data.services;

import org.springframework.stereotype.Service;

import ca.usherbrooke.mainapplication.data.GenericRepository;
import ca.usherbrooke.mainapplication.data.GenericService;
import ca.usherbrooke.mainapplication.data.entities.Role;
import ca.usherbrooke.mainapplication.data.repositories.RoleRepository;

@Service
public class RoleService implements GenericService<Role, String> {

	private final RoleRepository roleRepository;
	
	public RoleService(final RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Override
	public String getId(Role entity) {
		return entity.getNameRole();
	}

	@Override
	public GenericRepository<Role, String> getRepository() {
		return roleRepository;
	}
}
