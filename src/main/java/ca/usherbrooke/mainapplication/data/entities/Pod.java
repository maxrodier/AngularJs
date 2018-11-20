package ca.usherbrooke.mainapplication.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import ca.usherbrooke.mainapplication.data.GenericEntity;
import ca.usherbrooke.mainapplication.data.JsonViews;

@Entity
@Table(name = "pod")
public class Pod implements GenericEntity<Pod, String> {
	
	@Id
	@Column(name = "name_pod", columnDefinition = "VARCHAR(256)")
	@JsonView(JsonViews.Public.class)
	public String namePod;
	
	public Pod() { }
	
	public Pod(String namePod) {
		this.namePod = namePod;
	}

	@Override
	public Pod createFrom() {
		Pod entity = new Pod();
		return entity.updateWith(this);
	}

	@Override
	public Pod updateWith(Pod entity) {
		this.namePod = entity.namePod;
		return this;
	}

	@Override
	public String getId() {
		return this.namePod;
	}
	
	public String getNamePod() {
		return namePod;
	}

	public void setNamePod(String namePod) {
		this.namePod = namePod;
	}
}
