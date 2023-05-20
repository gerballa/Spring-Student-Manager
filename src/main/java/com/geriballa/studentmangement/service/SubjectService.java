package com.geriballa.studentmangement.service;

import com.geriballa.studentmangement.model.Subject;
import com.geriballa.studentmangement.model.User;
import com.geriballa.studentmangement.repository.SubjectRepository;
import com.geriballa.studentmangement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;

    @Autowired
    public SubjectService(SubjectRepository repository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.subjectRepository = repository;
    }

    public List<Subject> findSubjectsByTeacherId (String userId) {
        return this.subjectRepository.findSubjectsByTeacherId(userId);
    }
    public List<Subject> findSubjectsByStudentId (String userId) {
        User student = this.userRepository.findFirstById(userId);
        return this.subjectRepository.findSubjectsByStudents(student);
    }
    public Subject create(Subject subject) {
        return this.subjectRepository.save(subject);
    }

    public Subject addStudent(String subjectId, String studentId) throws Exception {
        // 1 - loads student and subject from their ids
        User student = this.userRepository.findFirstById(studentId);
        Subject subject = this.subjectRepository.findFirstById(subjectId);
        // check if student is already part in list
        if (subject.getStudents().contains(student)){
            throw new Exception("Student in already in this subject");
        }
        // 2 - add sduent in subject in List<User> students
        subject.getStudents().add(student);
        // 3 - save subject
        return this.subjectRepository.save(subject);
    }
    public Subject removeStudent(String subjectId, String studentId) throws Exception {
        User student = this.userRepository.findFirstById(studentId);
        Subject subject = this.subjectRepository.findFirstById(subjectId);
        if (!subject.getStudents().contains(student)){
            throw new Exception("Student isn't enrolled in this subject!");
        }
        subject.getStudents().remove(student);
        return this.subjectRepository.save(subject);
    }

}
