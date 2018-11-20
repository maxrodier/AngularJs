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
@Table(name = "user")
public class User implements GenericEntity<User, String> {
	
	@Id
	@Column(name = "username_user", columnDefinition = "VARCHAR(256)")
	@JsonView(JsonViews.Public.class)
	private String username;
	
	@Column(name = "firstname_user", columnDefinition = "VARCHAR(256)")
	@JsonView(JsonViews.Public.class)
	private String firstName;
	
	@Column(name = "lastname_user", columnDefinition = "VARCHAR(256)")
	@JsonView(JsonViews.Public.class)
	private String lastName;
	
	@Column(name = "email_user", columnDefinition = "VARCHAR(256)")
	@JsonView(JsonViews.Public.class)
	private String email;
	
	@ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(name = "project_user", joinColumns = {@JoinColumn(name = "fk_id_user")}, inverseJoinColumns = {@JoinColumn(name = "fk_id_project")})
	@JsonView(JsonViews.User.class)
    private Set<Project> projects;
	
	@ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "fk_id_user")}, inverseJoinColumns = {@JoinColumn(name = "fk_id_role")})
	@JsonView(JsonViews.User.class)
    private Set<Role> roles;
	
	public User() { }
	
	public User(String username, String firstName, String lastName, String email) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Override
	public User createFrom() {
		throw new IllegalStateException();
	}

	@Override
	public User updateWith(User entity) {
		throw new IllegalStateException();
	}
	
	@Override
	public String getId() {
		return this.username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
