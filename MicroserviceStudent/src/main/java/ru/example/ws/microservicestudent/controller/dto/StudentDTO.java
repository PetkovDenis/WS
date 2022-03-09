package ru.example.ws.microservicestudent.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {

    private int   id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String specialization;
    private int    age;
    private int    course;

}
