public class Student {
    /** Fields **/
    private String studentFirst;
    private String studentLast;
    private int grade;
    static int studentNumber = 1;
    int idNum;

    /** Default Constructor**/
    Student(){
        studentFirst = "";
        studentLast = "";
        grade = 0;
        idNum = studentNumber;
        studentNumber++;
    }
    /** Constructor **/
    Student(String studentFirst, String studentLast, int grade){ //Allows us to create students outside of the class
        this.studentFirst = studentFirst;
        this.studentLast = studentLast;
        this.grade = grade;
        this.idNum = studentNumber;
    }

    public String getStudentFirst() {
        return studentFirst;
    }

    public void setStudentFirst(String studentFirst) {
        this.studentFirst = studentFirst;
    }

    public String getStudentLast() {
        return studentLast;
    }

    public void setStudentLast(String studentLast) {
        this.studentLast = studentLast;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    /** Overrider **/
    public String toString(){ //Formats the location into a readable form.
        return "Name: " + this.studentFirst + " " + this.studentLast + "\t" + "Grade: " + this.grade + "\n";
    }
}
