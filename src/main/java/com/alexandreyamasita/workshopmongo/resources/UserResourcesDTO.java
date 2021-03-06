package com.alexandreyamasita.workshopmongo.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alexandreyamasita.workshopmongo.domain.User;
import com.alexandreyamasita.workshopmongo.dto.UserDTO;
import com.alexandreyamasita.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/usersdto")
public class UserResourcesDTO {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>>findAll()
	{	
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x-> new UserDTO(x)).collect(Collectors.toList());	
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) 
	{
		User obj = service.findById(id);		
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert( @RequestBody UserDTO objDto) {
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build(); //return 201 code when created one new resource
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id)	{		
		service.delete(id);		
		return ResponseEntity.noContent().build();   //return 204
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UserDTO objDTO,@PathVariable String id)
	{
		User obj = service.fromDTO(objDTO);
		obj.setId(id);
		service.update(obj);		
		return ResponseEntity.noContent().build();   //return 204		
	}

}
