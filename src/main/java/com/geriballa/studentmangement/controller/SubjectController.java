package com.geriballa.studentmangement.controller;

import com.geriballa.studentmangement.model.Subject;
import com.geriballa.studentmangement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subject")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(value = "/test")
    public String test() {
        return "test success";
    }

    @GetMapping(value = "/findAll/teacher/{teacherId}", produces = "application/json")
    public List<Subject> findTeacherSubjects(@PathVariable String teacherId) {
        List<Subject> subjectList = subjectService.findSubjectsByTeacherId(teacherId);
        return subjectList;
    }

    @GetMapping(value = "/findAll/student/{studentId}", produces = "application/json")
    public List<Subject> findStudentSubjects(@PathVariable String studentId) {
        List<Subject> subjectList = subjectService.findSubjectsByStudentId(studentId);
        return subjectList;
    }

    @PostMapping(value = "/create")
    public Subject create(@RequestBody Subject subjectToCreate) {
        Subject savedSubject = this.subjectService.create(subjectToCreate);
        return savedSubject;
    }

    @GetMapping(value = "/addStudent/{subjectId}/{studentId}")
    public Subject addStudent(@PathVariable String studentId, @PathVariable String subjectId) throws Exception {
        return this.subjectService.addStudent(subjectId, studentId);
    }

    @DeleteMapping(value = "removeStudent/{subjectId}/{studentId}")
    public Subject removeStudent(@PathVariable String studentId, @PathVariable String subjectId) throws Exception {
        return this.subjectService.removeStudent(subjectId, studentId);
    }
}
