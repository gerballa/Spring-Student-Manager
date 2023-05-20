package com.geriballa.studentmangement.service;

import com.geriballa.studentmangement.model.Grade;
import com.geriballa.studentmangement.model.Subject;
import com.geriballa.studentmangement.model.User;
import com.geriballa.studentmangement.repository.GradeRepository;
import com.geriballa.studentmangement.repository.SubjectRepository;
import com.geriballa.studentmangement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;


    @Autowired
    public GradeService(GradeRepository gradeRepository, UserRepository userRepository, SubjectRepository subjectRepository) {
        this.gradeRepository = gradeRepository;
        this.userRepository = userRepository;
        this.subjectRepository = subjectRepository;
    }

    public Grade saveGrade(Grade grade) {
        return this.gradeRepository.save(grade);
    }

    public List<Grade> getAllGradesByStudentId(String studentId){
        User student = this.userRepository.findFirstById(studentId);
        List<Grade> grades = this.gradeRepository.findAllByStudent(student);
        return grades;
    }

    public List<Grade> getAllGradesBySubjectId(String subjectId){
        Subject subject = this.subjectRepository.findFirstById(subjectId);
        List<Grade> grades = this.gradeRepository.findAllBySubject(subject);
        return grades;
    }

}
