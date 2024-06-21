package com.CRUD.demo;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();
    public ResponseEntity<String> add(@RequestBody StudentDTO studentDTO){
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        students.add(student);
        return ResponseEntity.ok("Student added successfully");
    }

    public List<StudentDTO> ga() {
        List<StudentDTO> studentDTOs = new ArrayList<>();
        for (Student student : students) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setName(student.getName());
            studentDTO.setAge(student.getAge());
            studentDTOs.add(studentDTO);
        }
        return studentDTOs;
    }

    public ResponseEntity<Integer> gb(@RequestParam String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return ResponseEntity.ok(student.getAge());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
