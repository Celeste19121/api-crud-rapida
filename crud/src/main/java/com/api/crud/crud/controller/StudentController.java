package com.api.crud.crud.controller;

import com.api.crud.crud.entity.Student;
import com.api.crud.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="api/v1/students")
public class StudentController {
    @Autowired
   private StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return studentService.getStudents();
    }
    @GetMapping("/{studentId}")
    public Optional<Student> getById(@PathVariable("studentId") Long studentId){
        return studentService.getStudents(studentId);
    }

    @PostMapping
    public Student saveOrUpdate(@RequestBody Student student){
         studentService.saveOrUpdate(student);
         return student;
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable("studentId") Long studentId){
        studentService.delet(studentId);

    }
}
