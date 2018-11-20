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
import ca.usherbrooke.mainapplication.data.entities.Role;
import ca.usherbrooke.mainapplication.data.services.RoleService;

@Controller
@RequestMapping("/api/role")
public class RoleController extends GenericController<Role, String> {

	public RoleController(RoleService service) {
		super(service);
	}

	@RequestMapping("")
	public String getView() {
		return "/views/data/role.html";
	}
	
	@RequestMapping("/")
	@JsonView(JsonViews.Role.class)
	@ResponseBody
	public ResponseEntity<List<Role>> getAll() {
		return super.getAll();
	}

	@RequestMapping("/{id}")
	@JsonView(JsonViews.Role.class)
	@ResponseBody
	public ResponseEntity<Role> getById(@PathVariable String id) {
		return super.getById(id);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@JsonView(JsonViews.Role.class)
	public @ResponseBody ResponseEntity<Role> create(@RequestBody Role createdEntity) {
		return super.create(createdEntity);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	@JsonView(JsonViews.Role.class)
	public @ResponseBody ResponseEntity<Role> update(@PathVariable String id, @RequestBody Role updatedEntity) {
		return super.update(id, updatedEntity);
	}

	@RequestMapping("/delete/{id}")
	@JsonView(JsonViews.Role.class)
	public @ResponseBody ResponseEntity<Role> delete(@PathVariable String id) {
		return super.delete(id);
	}
}