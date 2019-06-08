package com.alexandreyamasita.workshopmongo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alexandreyamasita.workshopmongo.domain.Post;
import com.alexandreyamasita.workshopmongo.domain.User;
import com.alexandreyamasita.workshopmongo.dto.UserDTO;
import com.alexandreyamasita.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResources {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>>findAll()
	{
	
		List<User> list = service.findAll();
	
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) 
	{
		User obj = service.findById(id);		
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert( @RequestBody User objUser) {		
		User obj = service.insert(objUser);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id)
	{		
		service.delete(id);		
		return ResponseEntity.noContent().build();   //return 204
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<User> update(@RequestBody User objUser,@PathVariable String id)
	{
		objUser.setId(id);
		service.update(objUser);	
		return ResponseEntity.noContent().build();   //return 204		
	}
	
	
	@RequestMapping(value="/{id}/posts", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByPosts(@PathVariable String id) 
	{
		User obj = service.findById(id);		
		return ResponseEntity.ok().body(obj.getPosts());
	}
	
}
