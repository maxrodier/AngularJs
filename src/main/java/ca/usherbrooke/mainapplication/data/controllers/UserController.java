package ca.usherbrooke.mainapplication.data.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;

import ca.usherbrooke.mainapplication.data.GenericController;
import ca.usherbrooke.mainapplication.data.JsonViews;
import ca.usherbrooke.mainapplication.data.entities.User;
import ca.usherbrooke.mainapplication.data.services.UserService;

@Controller
@RequestMapping("/api/user")
public class UserController extends GenericController<User, String> {

	public UserController(UserService service) {
		super(service);
	}
	
	@RequestMapping("")
	public String getView() {
		return "/views/data/user.html";
	}
	
	@RequestMapping("/")
	@JsonView(JsonViews.User.class)
	@ResponseBody
	public ResponseEntity<List<User>> getAll() {
		return super.getAll();
	}

	@RequestMapping("/{id}")
	@JsonView(JsonViews.User.class)
	@ResponseBody
	public ResponseEntity<User> getById(@PathVariable String id) {
		return super.getById(id);
	}
	
	@RequestMapping("/me")
	@JsonView(JsonViews.User.class)
	@ResponseBody
	public ResponseEntity<User> getMe() {
		try {
			User user = service.get(SecurityContextHolder.getContext().getAuthentication().getName());
			if(user == null)
				ResponseEntity.notFound().build();
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
