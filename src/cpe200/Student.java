package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private  String std_name;
    private  String student_id;
    private  int yob;
    private  boolean isActive;
    private static final String idREGEX = "5+[6-9]+0+6+1+[0-2]+[0-9]+[0-9]+[0-9]";

    public Student() {
        // implement here
        this("","",1990,false);
    }
    public Student(String n,String id,int y,boolean s){
        this.std_name = !n.equalsIgnoreCase("")?n:"John Doe";
        this.student_id=!isValidCourse_id(id)?"560610000":id;
        this.yob=(y>1990)?y:1990;
        this.isActive=s;
    }
    // implement all missing constructors here

    // implement all get and set methods here

    @Override
    public String toString() {
        String o;
        if(!isActive) {
             o = std_name + " (" + student_id + ") was born in " + yob + " is an INACTIVE student.";
        }
        else{
             o = std_name + " (" + student_id + ") was born in " + yob + " is an ACTIVE student.";
        }

        return o;
    }

    private boolean isValidStudent_id(String id) {
        return true;
    }

    private boolean isValidYOB(int yob) {
        return true;
    }

    // declare your attributes here
    public  String getName(){
        return std_name;
    }
    public  void  setName(String std_name){
        this.std_name = !std_name.equalsIgnoreCase("")?std_name:this.std_name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {

        this.student_id = isValidCourse_id(student_id)?student_id:this.student_id;
    }

    public int getYearOfBirth() {
        return yob;
    }

    public void setYearOfBirth(int yob) {
        this.yob= yob>1989?yob:this.yob;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

  //  "\\d{9}";
    private boolean isValidCourse_id(String id) {
        Pattern p = Pattern.compile(idREGEX);
        Matcher m = p.matcher(id);

             return m.matches();
    }

}
