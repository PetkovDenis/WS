package ru.example.ws.microservicestudent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.ws.microservicestudent.controller.dto.StudentDTO;
import ru.example.ws.microservicestudent.models.Student;
import ru.example.ws.microservicestudent.repository.StudentRepository;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService implements CRUDService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getOneStudent(int id) {
        return studentRepository.getById(id);
    }

    @Override
    public void deleteStudent(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new EntityExistsException("Student not found");
        }
    }

    @Override
    public Student createStudent(Student student) {
        Student studentSaved = studentRepository.save(student);
        if (studentRepository.existsById(studentSaved.getId())) {
            return studentSaved;
        } else {
            throw new EntityExistsException("Student not found");
        }
    }

    @Override
    public Student updateStudent(int id, Student student) {

        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            student.setId(id);
            studentRepository.save(student);
        } else {
            throw new EntityExistsException("Student not found");
        }
        return student;
    }
}


