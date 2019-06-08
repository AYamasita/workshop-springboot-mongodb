package com.alexandreyamasita.workshopmongo.respository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alexandreyamasita.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
