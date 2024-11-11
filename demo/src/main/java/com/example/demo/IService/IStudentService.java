package com.example.demo.IService;

import java.util.List;

import com.example.demo.Payload.Request.StudentRequest;
import com.example.demo.Payload.Response.StudentResponse;

public interface IStudentService  {

    void saveStudent(StudentRequest studentRequest);
    StudentResponse getStudentById(String studentId);
    List<StudentResponse> getAllStudent();
    void updateStudent(StudentRequest studentRequest , String studentId);
    void deleteById(String studentId);
    
}
    
