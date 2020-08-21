import java.util.ArrayList;


public class School {

    /** Fields **/
    private String schoolName;
    private String schoolLocation;
    private String schoolPopulation;

    /** Default School Constructor **/
    School(){
        schoolName = "";
        schoolLocation = "";
        schoolPopulation = "";
    }

    /** School Constructor **/
    School(String schoolName, String schoolLocation, String schoolPopulation){ //allows us to create a school outside of the class
        this.schoolName = schoolName;
        this.schoolLocation = schoolLocation;
        this.schoolPopulation = schoolPopulation;
    }


    /** ArrayList for schools **/
    ArrayList<School> schools = new ArrayList<>(); //Creates new ArrayList to store schools in

    /** Method for adding school **/
    public void addSchool(int index, School input){
        schools.add(index, input); //Adds inputted data to the specified index
    }
    /** Method for listing school **/
    public void listSchool(){
        for(int i = 0; i < schools.size(); i++){ //Assigns every index and element a number
            System.out.printf("" + schools.get(i)); //Prints out element stored at index
        }
    }

    /** School Overrider **/
    public String toString(){ //Formats the location into a readable form.
        return "School Name: " + this.schoolName + "\nSchool Location: " + this.schoolLocation + "\nPopulation: " + this.schoolPopulation + "\n";
    }

    /** ArrayLists for teachers, students, and courses **/
    ArrayList<Teacher> teachers = new ArrayList<>(); //Creates new ArrayList to store students in
    ArrayList<Student> students = new ArrayList<>(); //Creates new ArrayList to store teachers in
    ArrayList<String> courses = new ArrayList<String>(); //Creates new ArrayList to store courses in

    /** Methods for adding students and teachers **/
    public void addStudent(int index, Student input){ //Adds student first name, last name and grade into a certain index
        students.add(index, input);
    }
    public void addTeacher(int index, Teacher input){ //Adds teacher first name, last name, and subject into a certain index
        teachers.add(index, input);
    }

    /** Methods for listing students and teachers **/
    public void listStudent(){
        for(int i = 0; i < students.size(); i++){ //Assigns every index and element a number
            System.out.printf("" + students.get(i)); //Prints out element stored at index
        }
    }
    public void listTeacher(){
        for(int i = 0; i < teachers.size(); i++){ //Assigns every index and element a number
            System.out.printf("" + teachers.get(i)); //Prints out element stored at index
        }
    }

    /** Methods for deleting students and teachers **/
    public void deleteStudent(int index){
        if(index > students.size()){ //If the index inputted is smaller than the size of students ArrayList, follow next line
            System.out.println("ERROR1"); //Print error
        }
        else{ //Otherwise follow below
            System.out.println("Removing student: " + students.get(index)); //Prints which student is getting removed
            students.remove(index); //Removes student at inputted index
        }
    }
    public void deleteTeacher(int index){
        if (index > teachers.size()){ //If the index inputted is smaller than the size of teacher ArrayList, follow next line
            System.out.println("ERROR2"); //Print error
        } else { //Otherwise follow below
            System.out.println("Removing teacher: " + teachers.get(index)); //Prints which teacher is getting removed
            teachers.remove(index); //Removes teacher at inputted index
            courses.remove(index); //Removes the course that was taught by the teacher removed
        }
    }
    /** Adding courses to its respective Arraylist **/
    public void addCourses(int index, String input){
        courses.add(index, input);
    }
    public void listCourses(){
        for(int i = 0; i < courses.size(); i++){
            System.out.printf("" + courses.get(i) + "\n");
        }
    }
}
