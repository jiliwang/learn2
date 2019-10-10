package com.wj.service;

import com.wj.entity.Student;

import java.util.Collection;

public interface StudentService {
    public Collection<Student> findAll();
    public Student findById(long id);
    public void saveOrUpdate(Student student);
    public void deleteById(long id);
}
