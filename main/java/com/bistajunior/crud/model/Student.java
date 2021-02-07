/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bistajunior.crud.model;

/**
 *
 * @author bistajunior
 */
public class Student {
    private int id;
    private String name;
    private String course;
    
    public int getID()
    {
        return id;
    }
    public void setID(int id)
    {
        this.id=id;
        
    }
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name=name;
    }
    public String getCourse()
    {
        return course;
    }
    public void setCourse(String course)
    {
        this.course=course;
    }
}
