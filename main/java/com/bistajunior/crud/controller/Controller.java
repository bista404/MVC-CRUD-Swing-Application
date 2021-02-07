/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bistajunior.crud.controller;

/**
 *
 * @author princess
 */
import com.bistajunior.crud.model.Student;
import com.bistajunior.crud.model.dao.StudentImplementation;
import com.bistajunior.crud.model.Table.TableModelStudent;
import com.bistajunior.crud.model.dao.StudentDAO;
import com.bistajunior.crud.view.PanelForm;
import java.util.List;
import javax.swing.JOptionPane;
public class Controller {
    private final PanelForm panel;
    private List<Student>list;
    private final StudentImplementation implementStudent;
    
    public Controller(PanelForm panel)
    {
        this.panel=panel;
        implementStudent=new StudentDAO();
        list=implementStudent.getAllStudents();
    }
    public void reset()
    {
        panel.getTxtID().setText("");
        panel.getTxtName().setText("");
        panel.getTxtCourse().setText("");
        panel.getTableStudent().clearSelection();
    }
    
    public void fillTable()
    {
        list=implementStudent.getAllStudents();
        panel.getTableStudent().setModel(new TableModelStudent(list));
    }
    
    public void getDataField()
    {
        int row=panel.getTableStudent().getSelectedRow();
        if(row!=-1)
        {
            panel.getTxtID().setText(String.valueOf(list.get(row).getID()));
                panel.getTxtName().setText(list.get(row).getName());
            panel.getTxtCourse().setText(list.get(row).getCourse());
            
        }
    }
    public void insert()
    {
        Student  student =new Student();
        student.setName(panel.getTxtName().getText());
        student.setCourse(panel.getTxtCourse().getText());
        
        implementStudent.input(student);
        
    }
    public void update(){
        
        Student student = new Student();
        student.setID(Integer.parseInt(panel.getTxtID().getText()));
        student.setName(panel.getTxtName().getText());
        student.setCourse(panel.getTxtCourse().getText());
        
        implementStudent.update(student);
    
    }
    
    public void delete(){
        
        if (panel.getTxtID().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "No data deleted....? ",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int row = Integer.parseInt(panel.getTxtID().getText());
        
        implementStudent.delete(row);
        
    }
    
    
    public void getData(){
        
        if (panel.getTxtCourse().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Empty ", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String course = panel.getTxtCourse().getText();
        
        implementStudent.getCourse(course);
        tableCourse(course);
    }

   public void tableCourse(String course){
        
        list = implementStudent.getCourse(course);
        panel.getTableStudent().setModel(new TableModelStudent(list));
    }
    
}
