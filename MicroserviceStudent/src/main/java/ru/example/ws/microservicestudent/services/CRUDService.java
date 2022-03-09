package ru.example.ws.microservicestudent.services;

import ru.example.ws.microservicestudent.models.Student;

import java.util.List;
public interface CRUDService {

    Student getOneStudent(int id);

    void deleteStudent(int id);

    Student createStudent(Student student);

    Student updateStudent(int id, Student student);

}
