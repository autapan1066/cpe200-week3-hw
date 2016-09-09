package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Course {

    public Course() {
        this("","","",30);
      /*  course_name="TBA";
        course_id="000000";
        lecturer="TBA";
        max_students=30;
        no_students=0;*/
    }

    public Course(String n, String cid) {
        // implement here
        this.course_name = !n.equalsIgnoreCase("")?n:"TBA";
        this.course_id=!isValidCourse_id(cid)?"000000":cid;
        lecturer="TBA";
        max_students=30;
        no_students=0;
    }

    public Course(String n, String cid, String l) {
        // implement here
        this.course_name = !n.equalsIgnoreCase("")?n:"TBA";
        this.course_id=!isValidCourse_id(cid)?"000000":cid;
        this.lecturer= !l.equalsIgnoreCase("")?l:"TBA";
        max_students=30;
        no_students=0;
    }

    public Course(String n, String cid, String l, int max) {
        this.course_name = !n.equalsIgnoreCase("")?n:"TBA";
        // implement the rest here
    //    this.course_id=cid.equals("")?"000000":cid;
        this.course_id=!isValidCourse_id(cid)?"000000":cid;
        this.lecturer= !l.equalsIgnoreCase("")?l:"TBA";
        this.max_students=(max>=10)?max:30;
        this.no_students=0;
     /*   course_name=n;
        course_id=cid;
        lecturer=l;
        max_students=max;
        no_students=0;*/
    }
    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = !course_name.equalsIgnoreCase("")?course_name:this.course_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {

        this.course_id = isValidCourse_id(course_id)?course_id:this.course_id;

    }

    // implement the other get and set methods here
    public String getLecturer() {
        // implement here
        return lecturer;
    }

    public void setLecturer(String l) {
        // implement here
        this.lecturer = !l.equalsIgnoreCase("")?l:this.lecturer;
    }

    public int getMax_students() {
        // implement here
        return max_students;
    }

    public void setMax_students(int max_students) {
        // implement here
        this.max_students= max_students>=30?max_students:this.max_students;
    }

    public int getNo_students() {
        // implement here
        return no_students;
    }

    public void setNo_students(int no_students) {
        // implement here
        this.no_students= no_students<=max_students && no_students>=0?no_students:this.no_students;
    }

    @Override
    public String toString() {
        String o;
        if(no_students==0) {

             o = this.course_name + " ("
                    + this.course_id + "), Teacher: "
                    + this.lecturer + ", has NO" +
                    " student, [maximum: 60]";
        }
        else if(no_students==1) {

             o = this.course_name + " ("
                    + this.course_id + "), Teacher: "
                    + this.lecturer + ", has ONE" +
                    " student, [maximum: 60]";
        }
        else {

            o = this.course_name + " ("
                    + this.course_id + "), Teacher: "
                    + this.lecturer + ", has " +this.no_students+
                    " students, [maximum: 60]";
        }

     return o;
    }

    private boolean isValidCourse_id(String id) {
        Pattern p = Pattern.compile(idREGEX);
        Matcher m = p.matcher(id);

        // implement the rest here

        return m.matches();
    }

    // Regular expression for the Student ID pattern \d= 0-9
    private static final String idREGEX = "\\d{6}";

    // all private attributes
    private String course_name;
    private String course_id;
    private String lecturer;
    private int max_students;
    private int no_students;
}
