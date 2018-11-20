package ca.usherbrooke.mainapplication.data.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;

import ca.usherbrooke.mainapplication.data.GenericController;
import ca.usherbrooke.mainapplication.data.JsonViews;
import ca.usherbrooke.mainapplication.data.entities.Project;
import ca.usherbrooke.mainapplication.data.services.ProjectService;

@Controller
@RequestMapping("/api/project")
public class ProjectController extends GenericController<Project, String> {

	public ProjectController(ProjectService service) {
		super(service);
	}
	
	@RequestMapping("")
	public String getView() {
		return "/views/data/project.html";
	}
	
	@RequestMapping("/")
	@JsonView(JsonViews.Project.class)
	@ResponseBody
	public ResponseEntity<List<Project>> getAll() {
		return super.getAll();
	}

	@RequestMapping("/{id}")
	@JsonView(JsonViews.Project.class)
	@ResponseBody
	public ResponseEntity<Project> getById(@PathVariable String id) {
		return super.getById(id);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@JsonView(JsonViews.Project.class)
	public @ResponseBody ResponseEntity<Project> create(@RequestBody Project createdEntity) {
		return super.create(createdEntity);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	@JsonView(JsonViews.Project.class)
	public @ResponseBody ResponseEntity<Project> update(@PathVariable String id, @RequestBody Project updatedEntity) {
		return super.update(id, updatedEntity);
	}

	@RequestMapping("/delete/{id}")
	@JsonView(JsonViews.Project.class)
	public @ResponseBody ResponseEntity<Project> delete(@PathVariable String id) {
		return super.delete(id);
	}
}