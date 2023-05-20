package com.geriballa.studentmangement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
public class Grade {
    @Id
    private String id;
    @DBRef
    private Subject subject;
    @DBRef
    private User student;
    private Integer grade;


    //Grade Repository, service , controller>>>
}
