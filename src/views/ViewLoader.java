package views;


import javax.swing.*;

public class ViewLoader{

    public Index index = new Index();
    public QRcodeViews qrcodeViews = new QRcodeViews();
    public ReadQRViews readQRViews = new ReadQRViews();
    public RegistrationView registration = new RegistrationView();

    public JFrame frame;

    public ViewLoader(){
        frame = new JFrame();
        frame.setTitle("Attendance System");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);

        frame.add(index.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void switchView(JPanel oldPanel, JPanel newPanel){
        frame.remove(oldPanel);
        frame.add(newPanel);
        frame.revalidate();
        frame.repaint();

    }
}
