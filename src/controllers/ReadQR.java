package controllers;

import views.ReadQRViews;
import models.Student;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;

public class ReadQR {
    private ReadQRViews readQR;
    private Student model;

    public ReadQR(ReadQRViews view, Student model){
        this.readQR = view;
        this.model = model;

        view.textFieldListener(new changeListener());

    }

    class changeListener implements DocumentListener {
        private String studentIdModel = model.getStudentId();
        private String studentIdView = readQR.textarea.getText();

        @Override
        public void changedUpdate(DocumentEvent e) {
        }

        @Override
        public void insertUpdate(DocumentEvent documentEvent) {
            model.setStudentId(readQR.textarea.getText()); //set studentId attribute
            ArrayList<String> student = model.retrieveStudent();

            if(student.size() != 0 && !model.getAttendance()){ // check if student exist in the student list AND is not yet recorded in the attendance
                model.recordAttendance();
                readQR.name.setText(student.get(0));
            }
        }

        @Override
        public void removeUpdate(DocumentEvent documentEvent) {
        }

    }
}
