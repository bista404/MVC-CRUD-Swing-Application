/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bistajunior.crud.model.Table;

/**
 *
 * @author princess
 */
import com.bistajunior.crud.model.Student;
import java.util.List;
import javax.swing.table.AbstractTableModel;
public class TableModelStudent extends AbstractTableModel {
    private static final long serialVersionUID=1L;
    List<Student> list;
    
    public TableModelStudent(List<Student>list)
    {
        this.list=list;
    }
    @Override
    public int getRowCount()
    {
        return list.size();
    }
    @Override
    public int getColumnCount()
    {
        return 3;
    }
    @Override
    public Object getValueAt(int rowIndex,int columnIndex)
    {
        switch(columnIndex)
        {
            case 0:return list.get(rowIndex).getID();
            case 1:return list.get(rowIndex).getName();
            case 2:return list.get(rowIndex).getCourse();
            default: return null;
        }
    }
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0 : return "ID";
            case 1 : return "NAME";
            case 2 : return "COURSE";
                default:return null;
        }
    }
}
