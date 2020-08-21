public class Teacher {
    /** Fields **/
    private String teacherFirst;
    private String teacherLast;
    private String subject;

    /** Default Constructor **/
    Teacher(){
        teacherFirst = "";
        teacherLast = "";
        subject = "";
    }

    /** Constructor **/
    Teacher(String teacherFirst, String teacherLast, String subject){ //Allows us to create teachers outside of this class
        this.teacherFirst = teacherFirst;
        this.teacherLast = teacherLast;
        this.subject = subject;
    }


    public String getTeacherFirst() {
        return teacherFirst;
    }

    public void setTeacherFirst(String teacherFirst) {
        this.teacherFirst = teacherFirst;
    }

    public String getTeacherLast() {
        return teacherLast;
    }

    public void setTeacherLast(String teacherLast) {
        this.teacherLast = teacherLast;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /** Overrider **/
    public String toString(){ //Formats the location into a readable form.
        return "Name: " + this.teacherFirst + " " + this.teacherLast + "\t" + "Subject: " + this.subject + "\n";
    }
}
