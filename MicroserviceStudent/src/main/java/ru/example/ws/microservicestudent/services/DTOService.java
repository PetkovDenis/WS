package ru.example.ws.microservicestudent.services;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.ws.microservicestudent.controller.dto.StudentDTO;
import ru.example.ws.microservicestudent.models.Student;
import ru.example.ws.microservicestudent.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DTOService {

   private final StudentRepository repository;

    public DTOService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<StudentDTO> getAllDTO(){
      return  repository.findAll()
                .stream()
                .map(this::convertDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO convertDTO(Student student){
    StudentDTO studentDTO = new StudentDTO();
    studentDTO.setFirstName(student.getFirstName());
    studentDTO.setMiddleName(student.getMiddleName());
    studentDTO.setLastName(student.getLastName());
    studentDTO.setAge(student.getAge());
    studentDTO.setCourse(student.getCourse());
    studentDTO.setSpecialization(student.getSpecialization());
    studentDTO.setId(student.getId());
    return studentDTO;
    }
}
