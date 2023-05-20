package com.geriballa.studentmangement.repository;

import com.geriballa.studentmangement.model.Subject;
import com.geriballa.studentmangement.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, String> {
    List<Subject> findSubjectsByTeacherId(String teacherId);
    Subject findFirstById(String subjectId);
    List<Subject> findSubjectsByStudents(User student);
}
