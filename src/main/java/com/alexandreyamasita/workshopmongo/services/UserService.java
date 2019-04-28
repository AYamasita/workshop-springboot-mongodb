package com.alexandreyamasita.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandreyamasita.workshopmongo.domain.User;
import com.alexandreyamasita.workshopmongo.respository.UserRepository;
import com.alexandreyamasita.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService  {
	
	@Autowired   //injeção de dependencia automatica do SpringBoot
	private UserRepository repo;
	
	public List<User>findAll()
	{
		return repo.findAll();
	}
	
	public User findById(String id)
	{
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object was not found."));
	}

}
