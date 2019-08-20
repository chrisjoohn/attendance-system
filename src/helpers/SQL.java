package helpers;

import config.Configs;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


public class SQL {

    Configs config = new Configs();
    private String url=config.url;
    private String user=config.user;
    private String password=config.password;

    private Connection conn;

    public SQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,user,password);
            this.conn = conn;
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public boolean addStudentToDB(String firstName, String middleName, String lastName, int age, String studentId){
        String query = "INSERT INTO students(first_name, middle_name, last_name, age, studentId) VALUES (?,?,?,?,?)";
        boolean success=false;
        try{
            PreparedStatement prepSt = conn.prepareStatement(query);

            prepSt.setString(1,firstName);
            prepSt.setString(2,middleName);
            prepSt.setString(3,lastName);
            prepSt.setInt(4,age);
            prepSt.setString(5,studentId);

            prepSt.execute();
            success=true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return success;
    }

    public ArrayList<String> retrieveStudent(String studentId){
        String query="SELECT * FROM students WHERE studentId LIKE ?";
        ArrayList<String> student = new ArrayList<>();
        try{
            PreparedStatement prepSt = conn.prepareStatement(query);
            prepSt.setString(1, studentId);

            ResultSet rs = prepSt.executeQuery();
            while(rs.next()){
                student.add(rs.getString("first_name"));
                student.add(rs.getString("middle_name"));
                student.add(rs.getString("last_name"));
                student.add(rs.getString("age"));
                student.add(rs.getString("studentId"));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public ArrayList<ArrayList<String>> retrieveAllStudents(){
        String query = "SELECT * FROM students";
        ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();

        try{
            PreparedStatement prepSt = conn.prepareStatement(query);
            ResultSet rs = prepSt.executeQuery();
            while(rs.next()){
                ArrayList<String> data = new ArrayList<String>();
                data.add(rs.getString("first_name"));
                data.add(rs.getString("middle_name"));
                data.add(rs.getString("last_name"));
                data.add(rs.getString("age"));
                data.add(rs.getString("studentId"));

                datas.add(data);
            }
            return datas;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return datas;
    }

    public String getStudentId(String firstName, String middleName, String lastName){
        String query = "SELECT studentId FROM students WHERE first_name LIKE ? AND middle_name LIKE ? AND last_name LIKE ? ";
        String studentId = null;
        try{
            PreparedStatement prepSt = conn.prepareStatement(query);

            prepSt.setString(1, firstName);
            prepSt.setString(2, middleName);
            prepSt.setString(3, lastName);

            ResultSet rs = prepSt.executeQuery();

            while(rs.next()){
                studentId = rs.getString(1);
            }
        }catch(Exception e){
            System.out.println(e);
            System.out.println("getStudentId");
        }
        return studentId;
    }

    public void registerAttendance(String studentId){
        SimpleDateFormat date_formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat time_formatter = new SimpleDateFormat("hh:mm");
        Date date = new Date();
        String dates = date_formatter.format(date);
        String times = time_formatter.format(date);

        String query = "INSERT INTO attendance(studentId, date_recorded, time_recorded) VALUES(?,?,?)";

        try{
            PreparedStatement prepSt = conn.prepareStatement(query);

            prepSt.setString(1, studentId);
            prepSt.setString(2, dates);
            prepSt.setString(3, times);

            prepSt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public boolean recordedAttendance(String studentId){
        SimpleDateFormat date_formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dates = date_formatter.format(date);

        boolean exist=false;

        String query = "SELECT * FROM attendance WHERE date_recorded LIKE ? AND studentId LIKE ?";

        try{
            PreparedStatement prepSt = conn.prepareStatement(query);

            prepSt.setString(1, dates);
            prepSt.setString(2, studentId);

            ResultSet rs = prepSt.executeQuery();

            exist = rs.next();

        }catch (SQLException e){

        }

        return exist;
    }

}
