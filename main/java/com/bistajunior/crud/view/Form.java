/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bistajunior.crud.view;

/**
 *
 * @author princess
 */
public class Form extends javax.swing.JFrame {
     public Form() {
        initComponents();
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }

    private void initComponents() {
        panelForm1 = new com.bistajunior.crud.view.PanelForm();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(panelForm1, java.awt.BorderLayout.CENTER);

        pack();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        private com.bistajunior.crud.view.PanelForm panelForm1;

}
