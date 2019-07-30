package com.alexandreyamasita.workshopmongo.respository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.alexandreyamasita.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{ 'title': { $regex: ?0, $options:'i'} }")   //?0 -> primeiro parâmetro -> text
	List<Post> searchTitle(String text); //@Query 
	//https://docs.mongodb.com/manual/reference/operator/query/regex/
	
	List<Post>findByTitleContainingIgnoreCase(String text); //QueryMethod
	//https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/ 
	
}
