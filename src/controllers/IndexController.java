package controllers;

import views.Index;
import views.ViewLoader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndexController {

    ViewLoader viewLoader;
    Index indexView;


    public IndexController(Index indexView, ViewLoader viewLoader){
        this.viewLoader = viewLoader;
        this.indexView = indexView;

        indexView.generateBtnListener(new GenerateListener());
        indexView.registerBtnListener(new RegisterListener());
        indexView.scanBtnListener(new ScanListener());
    }

    class GenerateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent){
            viewLoader.switchView(indexView.panel, viewLoader.qrcodeViews.panel);
        }
    }

    class RegisterListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            viewLoader.switchView(indexView.panel, viewLoader.registration.panel);
        }
    }

    class ScanListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            viewLoader.readQRViews.setVisible(true);
        }
    }
}
