package controllers;

import helpers.QRcode;
import models.Student;
import org.omg.PortableInterceptor.ACTIVE;
import views.QRcodeViews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.google.zxing.WriterException;
import views.ViewLoader;

public class QRController {
    private ViewLoader viewLoader;
    private QRcode qr = new QRcode();
    private QRcodeViews view;
    private Student model;
    private final String Path="QRs/";

    public QRController(QRcodeViews view, Student model, ViewLoader viewLoader){
        this.view = view;
        this.model= model;
        this.viewLoader=viewLoader;


        view.addGenerateListener(new GenerateListener());
        view.addBackBtnListener(new BackListener());
    }

    class BackListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            viewLoader.switchView(view.panel, viewLoader.index.panel);
        }
    }

    class GenerateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            model.setFirstName(view.firstName.getText());
            model.setMiddleName(view.middleName.getText());
            model.setLastName(view.lastName.getText());
            String studentId = model.getStudentIdDB();
            String filePath = Path+studentId+".png";
            if(studentId != null){
                try {
                    qr.generateQRcode(studentId, filePath);
                    view.showSuccess();
                }catch (Exception ee){
                    ee.printStackTrace();
                    view.showFailure();
                }

            } else {
                view.showFailure("Student not found!");
            }
            view.reset();

        }
    }
}
