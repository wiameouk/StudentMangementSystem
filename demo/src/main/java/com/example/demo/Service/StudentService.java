package com.example.demo.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Student;
import com.example.demo.EntityRepository.StudentRepository;
import com.example.demo.Exception.NotFoundException;
import com.example.demo.IService.IStudentService;
import com.example.demo.Payload.Mapper.StudentMapper;
import com.example.demo.Payload.Request.StudentRequest;
import com.example.demo.Payload.Response.StudentResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService{
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    @Transactional
    public void saveStudent(StudentRequest studentRequest) {
        Student student = studentMapper.toStudent(studentRequest);
        studentRepository.save(student);
    }

    @Override
    public StudentResponse getStudentById(String studentId) {
        return studentRepository.findById(UUID.fromString(studentId))
            .map(studentMapper::toStudentResponse)
            .orElseThrow(()-> new NotFoundException("Cannot create student" +studentId));
    }

    @Override
    public List<StudentResponse> getAllStudent() {
        return studentRepository.findAll()
            .stream()
            .map(studentMapper::toStudentResponse)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateStudent(StudentRequest studentRequest, String studentId) {
          Student student = studentRepository.findById(UUID.fromString(studentId))
            .orElseThrow(() -> new NotFoundException("Cannot find student with id : " + studentId));
            student.setMatricule(studentRequest.matricule());
            student.setNom(studentRequest.nom());
            student.setPrenom(studentRequest.prenom());
            student.setAge(studentRequest.age());
            studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteById(String studentId) {
        if(studentRepository.existsById(UUID.fromString(studentId)))
        {
            studentRepository.deleteById(UUID.fromString(studentId));
        }else{
            throw new NotFoundException("Cannot find student with id : " + studentId);
        }
    }
}