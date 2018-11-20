package ca.usherbrooke.mainapplication.data.repositories;

import javax.transaction.Transactional;

import ca.usherbrooke.mainapplication.data.GenericRepository;
import ca.usherbrooke.mainapplication.data.entities.Role;

@Transactional
public interface RoleRepository extends GenericRepository<Role, String>{

}
