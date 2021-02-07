/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bistajunior.crud.model.dao;

/**
 *
 * @author princess
 */
import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.*;
import com.bistajunior.crud.model.Student;
import com.bistajunior.crud.model.database.DBConnection;
import java.util.logging.Logger;
public class StudentDAO implements StudentImplementation{
    private List<Student> list;
    @Override
    public void input(Student student)
    {
        try{
            PreparedStatement statement=DBConnection.getConnection().prepareStatement(""+ "INSERT INTO student(id,name,course)VALUES(NULL,?,?)");
            statement.setString(1,student.getName());
            statement.setString(2,student.getCourse());
            statement.executeUpdate();
            statement.close();
        } catch(SQLException e)
        {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE,null,e);
        } 
    }
    @Override
    public void update(Student student)
    {
        try
        {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(""+"UPDATE student SET name=?,course=? WHERE id=?");
            statement.setString(1,student.getName());
            statement.setString(2,student.getCourse());
            statement.setInt(3,student.getID());
            statement.executeUpdate();
            statement.close();
            
        }catch(SQLException e)
        {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null,e);
        }
    }
    @Override 
    public void delete(int id)
    {
        try
        {
            PreparedStatement statement=DBConnection.getConnection().prepareStatement(""+"DELETE FROM student WHERE id=?");
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
        }catch(SQLException e)
        {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null,e);
        }
    }
    
    @Override
    public List<Student>getCourse(String course)
    {
        list=new ArrayList<Student>();
        try
        {
            Statement statement =DBConnection.getConnection().createStatement();
            ResultSet result=statement.executeQuery("SELECT * FROM student WHERE course LIKE '%"+course+"%'");
            
            while(result.next())
            {
                Student student =new Student();
                student.setID(result.getInt(1));
                student.setName(result.getString("name"));
                student.setCourse(result.getString("course"));
                list.add(student);
                
                
            }
            statement.close();
            result.close();
            return list;
            
            
        }catch(SQLException e)
        {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null,e);
            return null;
        }
    }
        @Override
          public List<Student> getAllStudents()
        {
            list=new ArrayList<Student>();
            try
            {
                Statement statement=DBConnection.getConnection().createStatement();
                ResultSet result=statement.executeQuery("SELECT * FROM student");
                
                while(result.next())
                {
                    Student student=new Student();
                    student.setID(result.getInt(1));
                    student.setName(result.getString("name"));
                    student.setCourse(result.getString("course"));
                    list.add(student);
                }
                statement.close();
                result.close();
                return list;
            }catch(SQLException e)
            {
               Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE,null,e);
                return null;
            }
        }
}

    

