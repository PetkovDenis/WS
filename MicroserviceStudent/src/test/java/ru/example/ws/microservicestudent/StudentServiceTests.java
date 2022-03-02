package ru.example.ws.microservicestudent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.example.ws.microservicestudent.models.Student;
import ru.example.ws.microservicestudent.repository.StudentRepository;
import ru.example.ws.microservicestudent.services.StudentService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class StudentServiceTests {

    @Autowired
    StudentService service;

    @Test
    void addStudentTest() {
        var student = new Student("Test","Test","Test","Test",6,3);
        boolean result = service.addStudent(student);
        assertTrue(result, () -> "Student not add in DB");
    }

    @Test
    void studentDelete(){
        int id = 2;
        var result = service.deleteStudent(id);
        assertTrue(result,() -> "The student has not been removed");
    }
}
