package ca.usherbrooke.mainapplication.data.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import ca.usherbrooke.mainapplication.data.GenericEntity;
import ca.usherbrooke.mainapplication.data.JsonViews;

@Entity
@Table(name = "role")
public class Role implements GenericEntity<Role, String> {
	
	@Id
	@Column(name = "name_role", columnDefinition = "VARCHAR(256)")
	@JsonView(JsonViews.Public.class)
	public String nameRole;
	
	@ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "fk_id_role")}, inverseJoinColumns = {@JoinColumn(name = "fk_id_user")})
	@JsonView(JsonViews.Role.class)
    private Set<User> users;
	
	@ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(name = "project_role", joinColumns = {@JoinColumn(name = "fk_id_role")}, inverseJoinColumns = {@JoinColumn(name = "fk_id_project")})
	@JsonView(JsonViews.Role.class)
    private Set<Project> projects;
	
	public Role() { }
	
	public Role(String nameRole) {
		this.nameRole = nameRole;
	}

	@Override
	public Role createFrom() {
		return null;
	}

	@Override
	public Role updateWith(Role entity) {
		return null;
	}

	@Override
	public String getId() {
		return this.nameRole;
	}
	
	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}
}
