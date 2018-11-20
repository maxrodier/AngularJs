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
@Table(name = "project")
public class Project implements GenericEntity<Project, String> {

	@Id
	@Column(name = "name_project", columnDefinition = "VARCHAR(256)")
	@JsonView(JsonViews.Public.class)
	private String nameProject;
	
	@ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(name = "project_role", joinColumns = {@JoinColumn(name = "fk_id_project")}, inverseJoinColumns = {@JoinColumn(name = "fk_id_role")})
	@JsonView(JsonViews.Project.class)
    private Set<Role> roles;
	
	@ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(name = "project_user", joinColumns = {@JoinColumn(name = "fk_id_project")}, inverseJoinColumns = {@JoinColumn(name = "fk_id_user")})
	@JsonView(JsonViews.Project.class)
    private Set<User> users;
	
	public Project() { }
	
	public Project(String nameProject) {
		this.nameProject = nameProject;
	}

	@Override
	public Project createFrom() {
		return null;
	}

	@Override
	public Project updateWith(Project entity) {
		return null;
	}
	
	@Override
	public String getId() {
		return this.nameProject;
	}

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}
}
