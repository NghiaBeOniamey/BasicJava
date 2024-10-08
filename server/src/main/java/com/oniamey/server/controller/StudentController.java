package com.oniamey.server.controller;

import com.oniamey.server.model.request.StudentRequest;
import com.oniamey.server.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService service;

    @GetMapping
    public ResponseEntity<?> getStudents() {
        return service.getStudent();
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@Valid @RequestBody StudentRequest request) {
        return service.addStudent(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentRequest request) {
        return service.updateStudent(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        return service.deleteStudent(id);
    }

}
