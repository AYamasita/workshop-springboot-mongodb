package com.alexandreyamasita.workshopmongo.respository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alexandreyamasita.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post>findByTitleContainingIgnoreCase(String text); //QueryMethod
	
}
