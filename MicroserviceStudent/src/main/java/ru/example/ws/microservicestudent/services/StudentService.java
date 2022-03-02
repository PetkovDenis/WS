package ru.example.ws.microservicestudent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.ws.microservicestudent.dtos.StudentDTO;
import ru.example.ws.microservicestudent.models.Student;
import ru.example.ws.microservicestudent.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public List<StudentDTO> getAllDTOStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::convertStudentsDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO convertStudentsDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setMiddleName(student.getMiddleName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setAge(student.getAge());
        studentDTO.setCourse(student.getCourse());
        studentDTO.setSpecialization(student.getSpecialization());
        return studentDTO;
    }

    public boolean addStudent(Student student) {
        boolean studentStatus = false;
        studentRepository.save(student);
        if (studentRepository.existsById(student.getId())) {
            studentStatus = true;
        }
        return studentStatus;
    }

    public boolean deleteStudent(int id) {
        boolean result;
        if (studentRepository.existsById(id)) {
            result = true;
            studentRepository.deleteById(id);
        } else {
            result = false;
        }
        return result;
    }
}


