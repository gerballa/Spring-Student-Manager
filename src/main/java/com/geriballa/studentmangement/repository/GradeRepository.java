package com.geriballa.studentmangement.repository;

import com.geriballa.studentmangement.model.Grade;
import com.geriballa.studentmangement.model.Subject;
import com.geriballa.studentmangement.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends MongoRepository<Grade, String> {
    List<Grade> findAllByStudent(User student);

    List<Grade> findAllBySubject(Subject subject);
}
