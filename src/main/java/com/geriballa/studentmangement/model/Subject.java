package com.geriballa.studentmangement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
public class Subject {
    @Id
    private String id;
    private String name;
        private String description;
    @DBRef
    private User teacher;
    @DBRef
    private List<User> students;

    public Subject() {
        this.students = new ArrayList<>();
    }
}
