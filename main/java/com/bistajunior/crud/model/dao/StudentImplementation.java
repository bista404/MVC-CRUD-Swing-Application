/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bistajunior.crud.model.dao;

/**
 *
 * @author bistajunior
 */
import com.bistajunior.crud.model.Student;
import java.util.List;
public interface StudentImplementation {
    public void input(Student student);
    public void update(Student student);
    public void delete(int id);
    public List<Student> getCourse(String course);
    public List<Student>getAllStudents();
}
