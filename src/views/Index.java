package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Index {

    JButton register, scan, generate;
    public JPanel panel;


    public Index() {
        panel = new JPanel();
        panel.setSize(300, 300);
        panel.setLayout(new FlowLayout());

        register = new JButton("Register a student");
        scan = new JButton("Scan QR");
        generate = new JButton("Generate QR");

        panel.add(register);
        panel.add(scan);
        panel.add(generate);
    }

    public void registerBtnListener(ActionListener actionListener){
        register.addActionListener(actionListener);
    }

    public void scanBtnListener(ActionListener actionListener){
        scan.addActionListener(actionListener);
    }

    public void generateBtnListener(ActionListener actionListener){
        generate.addActionListener(actionListener);
    }
}
