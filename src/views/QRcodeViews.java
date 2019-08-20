package views;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class QRcodeViews{

    public JPanel panel;
    JButton generateBtn, resetBtn, backBtn;
    public JTextField firstName, middleName, lastName;
    JLabel firstName_label, middleName_label, lastName_label;


    public QRcodeViews(){
        panel = new JPanel();
        panel.setSize(200,250);
        panel.setLayout(new FlowLayout());

        firstName_label = new JLabel("First name:");
        firstName = new JTextField(15);

        middleName_label = new JLabel("Middle name:");
        middleName = new JTextField(15);

        lastName_label = new JLabel("Last name:");
        lastName = new JTextField(15);

        generateBtn = new JButton("Generate");
        backBtn = new JButton("Back");

        panel.add(firstName_label);
        panel.add(firstName);
        panel.add(middleName_label);
        panel.add(middleName);
        panel.add(lastName_label);
        panel.add(lastName);
        panel.add(generateBtn);
        panel.add(backBtn);

    }

    public void addGenerateListener(ActionListener generate){
        generateBtn.addActionListener(generate);

    }

    public void addBackBtnListener(ActionListener actionListener){
        backBtn.addActionListener(actionListener);
    }

    public void reset(){
        this.firstName.setText("");
        this.middleName.setText("");
        this.lastName.setText("");
    }

    public void showSuccess(){
        JOptionPane.showMessageDialog(panel, "QR code generated!");
    }

    public void showFailure(){
        JOptionPane.showMessageDialog(panel, "Something went wrong");
    }

    public void showFailure(String message){
        JOptionPane.showMessageDialog(panel, message);
    }


}
