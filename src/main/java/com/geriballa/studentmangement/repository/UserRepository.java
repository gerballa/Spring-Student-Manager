package com.geriballa.studentmangement.repository;

import com.geriballa.studentmangement.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
     User findFirstByLastNameAndPassword(String lastName, String password);
     User findFirstById(String userId);
}

