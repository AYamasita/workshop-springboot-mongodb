package com.alexandreyamasita.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandreyamasita.workshopmongo.domain.Post;
import com.alexandreyamasita.workshopmongo.respository.PostRepository;
import com.alexandreyamasita.workshopmongo.services.exception.ObjectNotFoundException;


@Service
public class PostService {
	
	@Autowired   //injeção de dependência automatica do SpringBoot
	private PostRepository repo;
	
	public Post findById(String id)
	{
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object was not found."));
	}
	
	public List<Post> findByTitle(String text)
	{
		//return repo.findByTitleContainingIgnoreCase(text);
		return repo.searchTitle(text);
	}
	
	public List<Post> FullSearch(String text, Date minDate, Date maxDate)
	{
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); 
		return repo.FullSearch(text, minDate, maxDate);		
	}

}
