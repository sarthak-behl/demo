package com.CRUD.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {


    @Autowired
    private StudentService studentService;

    private List<Student> students = new ArrayList<>();

    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.add(studentDTO);
    }

    @GetMapping("/getAll")
    public List<StudentDTO> getAll() {
        return studentService.ga();
    }

    @GetMapping("/getBy")
    public ResponseEntity<Integer> getBy(@RequestParam String name) {
        return studentService.gb(name);
    }
}