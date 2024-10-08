package com.oniamey.server.service.impl;

import com.oniamey.server.entity.Student;
import com.oniamey.server.model.request.StudentRequest;
import com.oniamey.server.repository.StudentRepository;
import com.oniamey.server.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public ResponseEntity<?> getStudent() {
        return new ResponseEntity<>(studentRepository.getStudents(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addStudent(StudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setCode(request.getCode());
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateStudent(Long id, StudentRequest request) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            student.setName(request.getName());
            student.setCode(request.getCode());
            return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
        }
        return new ResponseEntity<>( "Student not found",HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> deleteStudent(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            studentRepository.delete(student);
            return new ResponseEntity<>( "Delete Success", HttpStatus.OK);
        }
        return new ResponseEntity<>( "Student not found",HttpStatus.BAD_REQUEST);
    }

}
