package com.alexandreyamasita.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandreyamasita.workshopmongo.domain.User;
import com.alexandreyamasita.workshopmongo.respository.UserRepository;

@Service
public class UserService  {
	
	@Autowired   //injeção de dependencia automatica do SpringBoot
	private UserRepository repo;
	
	public List<User>findAll()
	{
		return repo.findAll();
	}
	

}
