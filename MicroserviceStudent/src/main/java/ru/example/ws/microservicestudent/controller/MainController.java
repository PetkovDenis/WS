package ru.example.ws.microservicestudent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.example.ws.microservicestudent.dtos.StudentDTO;
import ru.example.ws.microservicestudent.models.Student;
import ru.example.ws.microservicestudent.services.StudentService;

import java.util.List;

@Controller
public class MainController {

    private final StudentService service;

    @Autowired
    public MainController(StudentService service) {
        this.service = service;
    }

    @GetMapping()
    public String mainPage() {
        return "mainPage";
    }

    @GetMapping("/studentsList")
    @ResponseBody
    public List<StudentDTO> studentList() {
        return service.getAllDTOStudents();
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
