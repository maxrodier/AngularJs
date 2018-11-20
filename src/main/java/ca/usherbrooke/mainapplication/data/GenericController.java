package ca.usherbrooke.mainapplication.data;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class GenericController<T extends GenericEntity<T, I>, I extends Serializable> {
	
	public GenericService<T, I> service;

	public GenericController(GenericService<T, I> service) {
		this.service = service;
	}
	
	public ResponseEntity<List<T>> getAll() {
		try {
			List<T> list = service.findAll();
			return new ResponseEntity<List<T>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	public ResponseEntity<T> getById(I id) {
		try {
			if (id == null)
				return ResponseEntity.badRequest().build();

			T entity = service.get(id);
			if (entity == null)
				return ResponseEntity.notFound().build();
			return new ResponseEntity<T>(entity, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	public ResponseEntity<T> create(T createdEntity) {
		try {
			if (createdEntity == null)
				return ResponseEntity.badRequest().build();

			T entity = ((T) createdEntity.createFrom());
			service.save(entity);

			return new ResponseEntity<T>(entity, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	public ResponseEntity<T> update(I id, T updatedEntity) {
		try {
			if (id == null || updatedEntity == null)
				return ResponseEntity.badRequest().build();

			T entity = service.get(id);
			if (entity == null)
				return ResponseEntity.notFound().build();

			if(updatedEntity.getId().equals(id) ? true : false) {
				entity.updateWith(updatedEntity);
				service.update(entity);
			} else {
				delete(id);
				create(updatedEntity);
			}

			return new ResponseEntity<T>(entity, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	public ResponseEntity<T> delete(I id) {
		try {
			if (id == null)
				return ResponseEntity.badRequest().build();

			T entity = service.get(id);
			if (entity == null)
				return ResponseEntity.notFound().build();
			service.delete(id);
			entity = service.get(id);

			return new ResponseEntity<T>(entity, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
