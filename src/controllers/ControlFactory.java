package controllers;


import models.ModelFactory;
import views.Index;
import views.ViewLoader;

public class ControlFactory {
    QRController qrController;
    ReadQR readQR;
    Registration registration;
    ViewLoader viewLoader;
    ModelFactory modelFactory;
    IndexController indexController;

    public ControlFactory(ViewLoader viewLoader, ModelFactory modelFactory){
        this.viewLoader = viewLoader;
        this.modelFactory = modelFactory;

        indexController = new IndexController(viewLoader.index, viewLoader);

        qrController = new QRController(viewLoader.qrcodeViews, modelFactory.student, viewLoader);
        readQR = new ReadQR(viewLoader.readQRViews, modelFactory.student);
        registration = new Registration(viewLoader.registration,modelFactory.student, viewLoader);
    }



}
