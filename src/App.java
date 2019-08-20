
import controllers.ControlFactory;
import controllers.QRController;
import models.ModelFactory;
import models.Student;
import views.RegistrationView;
import views.ViewLoader;

import java.util.*;

public class App {

    public static void main(String[] args){


        Student model = new Student();

        ModelFactory modelFactory = new ModelFactory();
        ViewLoader viewLoader = new ViewLoader();

        ControlFactory controlFactory = new ControlFactory(viewLoader, modelFactory);

        viewLoader.frame.setVisible(true);

        // For Retrieving Students in DB
        ArrayList<ArrayList<String>> students = new ArrayList<ArrayList<String>>();

        students = model.retrieveAllStudents();

        for(int i=0; i<students.size();i++){
            System.out.println(students.get(i));
        }

    }


}
