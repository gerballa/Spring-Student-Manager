package com.geriballa.studentmangement.controller;

import com.geriballa.studentmangement.model.Grade;
import com.geriballa.studentmangement.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("grade")
public class GradeController {

    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping(value = "/create")
    public Grade create(@RequestBody Grade gradeToCreate) {
        Grade savedGrade = this.gradeService.saveGrade(gradeToCreate);
        return savedGrade;
    }

    @GetMapping(value = "/student/{studentsId})")
    public List<Grade> findGradesByStudentId(@PathVariable String studentsId) {
        List<Grade> foundGrades = this.gradeService.getAllGradesByStudentId(studentsId);
        return foundGrades;
    }
    @GetMapping(value ="/subject/{gradesId}" )
    public List<Grade> findGradesByGradeId(@PathVariable String gradesId) {
        List<Grade> foundGrades = this.gradeService.getAllGradesByStudentId(gradesId);
        return foundGrades;
    }

}
