package com.geriballa.studentmangement.model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;


@Document
@Getter
@Setter
public class User {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String password;
    private boolean student;
    private int year;

    public User(String firstName, String lastName, String password, boolean student, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.student = student;
        this.year = year;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, password, student, year);
    }
}

