package controllers;

import java.awt.event.*;

import models.Student;
import views.RegistrationView;
import views.ViewLoader;

public class Registration {
    private RegistrationView view;
    private Student model;
    private ViewLoader viewLoader;

    public Registration(RegistrationView view, Student model, ViewLoader viewLoader){

        this.viewLoader = viewLoader;
        this.view = view;
        this.model = model;

        view.addResetListener(new ResetListener());
        view.SubmitListener(new SubmitListener());
        view.backBtnListener(new BackListener());
    }

    class BackListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            viewLoader.switchView(viewLoader.registration.panel, viewLoader.index.panel);
        }
    }

    class ResetListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            view.reset();
        }
    }

    class SubmitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                model.setFirstName(view.firstName.getText());
                model.setMiddleName(view.middleName.getText());
                model.setLastName(view.lastName.getText());
                model.setAge(new Integer(view.age.getText()));
                model.setStudentId(view.studentId.getText());
                if(model.retrieveStudent() == null) {
                    if (model.addStudentToDB()) {
                        view.showSuccess();
                        view.reset();
                    }else{
                        view.showFailure("ERROR IN DATABASE");
                    }
                }else {
                    view.showFailure("STUDENT ALREADY REGISTERED!");
                }

            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
    }


}
