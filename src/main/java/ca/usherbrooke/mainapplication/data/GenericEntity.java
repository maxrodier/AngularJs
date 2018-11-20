package ca.usherbrooke.mainapplication.data;

import java.io.Serializable;

public interface GenericEntity<T, I extends Serializable> {
	
	public T createFrom();
	public T updateWith(T entity);
	public I getId();
}
