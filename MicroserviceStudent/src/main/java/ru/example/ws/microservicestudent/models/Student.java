package ru.example.ws.microservicestudent.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "students")
public class Student {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "middlename")
    private String middleName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "specialization")
    private String specialization;
    @Column(name = "age")
    private int    age;
    @Column(name = "course")
    private int    course;

    public Student(String firstName, String middleName, String lastName, String specialization, int age, int course) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.age = age;
        this.course = course;
    }
    public Student() {}

}
