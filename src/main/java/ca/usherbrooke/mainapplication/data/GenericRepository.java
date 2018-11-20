package ca.usherbrooke.mainapplication.data;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends GenericEntity<T, I>, I extends Serializable> extends JpaRepository<T, I> {

}
