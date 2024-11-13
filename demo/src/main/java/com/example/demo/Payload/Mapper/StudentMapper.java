package com.example.demo.Payload.Mapper;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Payload.Request.StudentRequest;
import com.example.demo.Payload.Response.StudentResponse;

@Service
public class StudentMapper {

    public Student toStudent(StudentRequest studentRequest)
    {
        return Student.builder()
            .matricule(studentRequest.matricule())
            .prenom(studentRequest.prenom())
            .nom(studentRequest.nom())
            .age(studentRequest.age())
            .build(); 
    }

    public StudentResponse toStudentResponse(Student student)
    {
        return new StudentResponse(
            student.getId().toString(),
            student.getMatricule(),
            student.getNom(),
            student.getPrenom(), 
            student.getAge()
        );
    }
    
}
