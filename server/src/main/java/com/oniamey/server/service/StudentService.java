package com.oniamey.server.service;

import com.oniamey.server.model.request.StudentRequest;
import org.springframework.http.ResponseEntity;

public interface StudentService {

    ResponseEntity<?> getStudent();

    ResponseEntity<?> addStudent(StudentRequest request);

    ResponseEntity<?> updateStudent(Long id, StudentRequest request);

    ResponseEntity<?> deleteStudent(Long id);


}
