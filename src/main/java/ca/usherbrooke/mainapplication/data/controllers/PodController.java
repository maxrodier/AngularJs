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
import ca.usherbrooke.mainapplication.data.entities.Pod;
import ca.usherbrooke.mainapplication.data.services.PodService;

@Controller
@RequestMapping("/api/pod")
public class PodController extends GenericController<Pod, String> {

	public PodController(PodService service) {
		super(service);
	}
	
	@RequestMapping("")
	public String getView() {
		return "/views/data/pod.html";
	}
	
	@RequestMapping("/")
	@JsonView(JsonViews.Pod.class)
	@ResponseBody
	public ResponseEntity<List<Pod>> getAll() {
		return super.getAll();
	}

	@RequestMapping("/{id}")
	@JsonView(JsonViews.Pod.class)
	@ResponseBody
	public ResponseEntity<Pod> getById(@PathVariable String id) {
		return super.getById(id);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@JsonView(JsonViews.Pod.class)
	public @ResponseBody ResponseEntity<Pod> create(@RequestBody Pod createdEntity) {
		return super.create(createdEntity);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	@JsonView(JsonViews.Pod.class)
	public @ResponseBody ResponseEntity<Pod> update(@PathVariable String id, @RequestBody Pod updatedEntity) {
		return super.update(id, updatedEntity);
	}

	@RequestMapping("/delete/{id}")
	@JsonView(JsonViews.Pod.class)
	public @ResponseBody ResponseEntity<Pod> delete(@PathVariable String id) {
		return super.delete(id);
	}
}