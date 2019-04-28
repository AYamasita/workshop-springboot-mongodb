package com.alexandreyamasita.workshopmongo.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.alexandreyamasita.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
