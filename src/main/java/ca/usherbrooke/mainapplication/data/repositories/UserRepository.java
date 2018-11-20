package ca.usherbrooke.mainapplication.data.repositories;

import javax.transaction.Transactional;

import ca.usherbrooke.mainapplication.data.GenericRepository;
import ca.usherbrooke.mainapplication.data.entities.User;

@Transactional
public interface UserRepository extends GenericRepository<User, String>{

}