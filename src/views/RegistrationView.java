package views;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;


public class RegistrationView{

    public JPanel panel;
    private JButton submitBtn, resetBtn, backBtn;
    public JTextField firstName, middleName, lastName, age, studentId;
    private JLabel firstName_label, middleName_label, lastName_label, age_label, studentId_label;

    public RegistrationView(){

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setSize(500,200);

        //labels
        firstName_label = new JLabel("First name: ");
        middleName_label = new JLabel("Middle name: ");
        lastName_label = new JLabel("Last name: ");
        age_label = new JLabel("Age: ");
        studentId_label = new JLabel("Student No.: ");


        //text fields
        firstName = new JTextField(30);
        middleName = new JTextField(30);
        lastName = new JTextField(35);
        age = new JTextField(10);
        studentId = new JTextField(15);

        //buttons
        submitBtn = new JButton("Submit");
        resetBtn = new JButton("Reset");
        backBtn = new JButton("back");

        panel.add(firstName_label);
        panel.add(firstName);
        panel.add(middleName_label);
        panel.add(middleName);
        panel.add(lastName_label);
        panel.add(lastName);
        panel.add(age_label);
        panel.add(age);
        panel.add(studentId_label);
        panel.add(studentId);
        panel.add(submitBtn);
        panel.add(resetBtn);
        panel.add(backBtn);
    }

    public void reset(){
        firstName.setText("");
        middleName.setText("");
        lastName.setText("");
        age.setText("");
        studentId.setText("");
    }



    public void showSuccess(){
        JOptionPane.showMessageDialog(panel,"You have successfully registered an account!");
    }

    public void showFailure(String message){
        JOptionPane.showMessageDialog(panel, message);
    }

    public void addResetListener(ActionListener reset){
        resetBtn.addActionListener(reset);
    }

    public void SubmitListener(ActionListener submit){
        submitBtn.addActionListener(submit);
    }

    public void backBtnListener(ActionListener actionListener){
        backBtn.addActionListener(actionListener);
    }
}
