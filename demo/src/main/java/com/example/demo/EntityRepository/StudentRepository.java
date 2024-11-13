package com.example.demo.EntityRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,UUID>{   
}
