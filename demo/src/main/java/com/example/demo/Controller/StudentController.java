package com.example.demo.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Payload.Request.StudentRequest;
import com.example.demo.Payload.Response.StudentResponse;
import com.example.demo.Service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor

public class StudentController {
    
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Void> createStudent(@RequestBody @Valid StudentRequest studentRequest){
        studentService.saveStudent(studentRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);   
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentAll(@PathVariable("id")String studentId){
        return ResponseEntity.ok(studentService.getStudentById(studentId));    
    }
    @GetMapping
    public ResponseEntity<List<StudentResponse>>getStudentAll(){
        return ResponseEntity.ok(studentService.getAllStudent());   
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudentById(@RequestBody @Valid StudentRequest studentRequest, @PathVariable("id") String studentId){
        studentService.updateStudent(studentRequest, studentId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") String studentId)
    {
        studentService.deleteById(studentId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
}
