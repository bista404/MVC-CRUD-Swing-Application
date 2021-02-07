/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bistajunior.crud.model.database;

/**
 *
 * @author bistajunior
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    private static Connection connect;

    public static Connection getConnection()  {
        if(connect==null)
        {
            try
            {
                connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","root");
                System.out.println("Connected");
            }catch( SQLException e)
            {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,null,e);
            }
        }
        return connect;

    }
    public static void main(String[]args)
    {
        DBConnection.getConnection();
    }

}
