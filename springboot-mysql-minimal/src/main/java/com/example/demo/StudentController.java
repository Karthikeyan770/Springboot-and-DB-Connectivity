package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Student> all() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Student one(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
        return repository.save(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student input) {
        return repository.findById(id).map(student -> {
            student.setName(input.getName());
            student.setEmail(input.getEmail());
            return repository.save(student);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "Student deleted";
    }
}
