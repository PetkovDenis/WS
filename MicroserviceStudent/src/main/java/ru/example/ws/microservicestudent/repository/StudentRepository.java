package ru.example.ws.microservicestudent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.ws.microservicestudent.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
