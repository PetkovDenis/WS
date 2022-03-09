package ru.example.ws.microservicestudent.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.example.ws.microservicestudent.controller.dto.StudentDTO;
import ru.example.ws.microservicestudent.models.Student;
import ru.example.ws.microservicestudent.services.DTOService;
import ru.example.ws.microservicestudent.services.StudentService;

import java.util.List;

@Controller
public class MainController {

    private final StudentService service;
    private final DTOService dtoService;

    @Autowired
    public MainController(StudentService service, DTOService dtoService) {
        this.service = service;
        this.dtoService = dtoService;
    }

    @GetMapping()
    public String mainPage() {
        return "mainPage";
    }

    @GetMapping("/studentsList")
    @ResponseBody
    public List<StudentDTO> studentList() {
        return dtoService.getAllDTO();
    }

    @GetMapping("/list")
    public String list() {
        return "studentList";
    }

    @GetMapping("/add")
    public String addFormStudents() {
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String studentAdd(@RequestParam("name") String name,
                             @RequestParam("middleName") String middleName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("specialization") String specialization,
                             @RequestParam("age") int age,
                             @RequestParam("course") int course) {
        Student student = new Student(name, middleName, lastName, specialization, age, course);
        service.addStudent(student);
        return "mainPage";
    }

    @PostMapping("/delete/{id}")
    public String studentDelete(@PathVariable("id") int id) {
        service.deleteStudent(id);
        return "redirect:/";
    }
}
