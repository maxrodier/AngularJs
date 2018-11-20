package ca.usherbrooke.mainapplication.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.RollbackException;

public interface GenericService<T extends GenericEntity<T, I>, I extends Serializable> {
	public default List<T> findAll() {
		Iterable<T> list = getRepository().findAll();
		List<T> arrayList = new ArrayList<>();

		for (T entity : list) {
			arrayList.add(entity);
		}
		return arrayList;
	}

	public default T get(I id) {
		Optional<T> entity = getRepository().findById(id);
		if (entity.isPresent()) {
			return entity.get();
		}
		return null;
	}

	public default T save(T entity) {
		T result;

		try {
			result = getRepository().save(entity);
			return result;
		} catch (RollbackException e) {
			throw new RuntimeException("Entity not found");
		}
	}

	public default T update(T entity) {
		T result;

		if (getRepository().existsById(getId(entity))) {
			result = save(entity);
			return result;
		} else {
			throw new RuntimeException("Entity not found");
		}
	}

	public default void delete(I id) {
		if (getRepository().existsById(id)) {
			getRepository().deleteById(id);
		} else {
			throw new RuntimeException("Entity not found");
		}
	}

	public I getId(T entity);

	public GenericRepository<T, I> getRepository();
}
