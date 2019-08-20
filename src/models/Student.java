package models;

import helpers.SQL;
import java.util.*;

public class Student {

    private String firstName;
    private String middleName;
    private String lastName;
    private String studentId;
    private Integer age;

    private SQL source = new SQL();

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setStudentId(String studentId){
        this.studentId = studentId;
    }

    public String getStudentId(){ return this.studentId; }

    //CREATE
    public boolean addStudentToDB(){
        boolean success=false;
        try {
            if(source.addStudentToDB(
                    this.firstName,
                    this.middleName,
                    this.lastName,
                    this.age,
                    this.studentId
            )) {
                success = true;
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Adding student to database");
        }
        return success;
    }

    //RETRIEVE

    public ArrayList<String> retrieveStudent(){
        return source.retrieveStudent(this.studentId);
    }

    public ArrayList<ArrayList<String>> retrieveAllStudents(){
        return source.retrieveAllStudents();
    }

    public String getStudentIdDB(){
        return source.getStudentId(
                this.firstName,
                this.middleName,
                this.lastName
        );
    }

    public void recordAttendance(){
        source.registerAttendance(this.studentId);
    }

    public boolean getAttendance(){
        return source.recordedAttendance(this.studentId);
    }


}
