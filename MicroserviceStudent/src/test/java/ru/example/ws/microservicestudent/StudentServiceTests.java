package ru.example.ws.microservicestudent;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.example.ws.microservicestudent.models.Student;
import ru.example.ws.microservicestudent.repository.StudentRepository;
import ru.example.ws.microservicestudent.services.StudentService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class StudentServiceTests {

    @Autowired
    StudentService service;

    @BeforeEach
    void startedMethod(){
        System.out.println("Test is running");
    }

//    @Test
//    void addStudentTest() {
//        Student student = new Student("Test","Test","Test","Test",6,3);
//        boolean result = service.addStudent(student);
//        assertTrue(result, () -> "Student not add in DB");
//    }

//    @Test
//    void deleteStudent(int id){
//        var result = service.deleteStudent(id);
//        assertTrue(result,() -> "The student has not been removed");
//    }

    @AfterEach
    void finishMethod(){
        System.out.println("Test finished");
    }
}
