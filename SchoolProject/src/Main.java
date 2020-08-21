
public class Main {
    public static void main(String[] args){
        School s = new School("Generic School", "Generic City", "5000 Students");; //Creates a new school that is accessible in main.
        s.addSchool(0, s);
        s.listSchool();

        System.out.println("\nAdding 10 students to the students list\nAdding 3 teachers to the teachers list\n");

        //Add 10 students to the "students" ArrayList
        Student studentOne = new Student("Jamal", "Smith", 9);
        Student studentTwo = new Student("Tyrone", "Ball", 12);
        Student studentThree = new Student("Requis", "Woods", 5);
        Student studentFour = new Student ("James", "Lebron", 11);
        Student studentFive = new Student ("Evann", "Li   ", 12);
        Student studentSix = new Student ("Paula", "Valencia", 10);
        Student studentSeven = new Student ("Ronalda", "Dequavis", 3);
        Student studentEight = new Student ("Suzanne", "Oliver", 7);
        Student studentNine = new Student ("Ladonna", "Stout", 9);
        Student studentTen = new Student ("Ellen", "Baker", 10);
        s.addStudent(0, studentOne);
        s.addStudent(1, studentTwo);
        s.addStudent(2, studentThree);
        s.addStudent(3, studentFour);
        s.addStudent(4, studentFive);
        s.addStudent(5, studentSix);
        s.addStudent(6, studentSeven);
        s.addStudent(7, studentEight);
        s.addStudent(8, studentNine);
        s.addStudent(9, studentTen);

        //Add 3 teachers to the "teachers" ArrayList
        Teacher teacherOne = new Teacher ("Jeff", "Smith", "Physical Education");
        Teacher teacherTwo = new Teacher ("Daniel", "Chan","Math");
        Teacher teacherThree = new Teacher("Angus", "Beef", "Food Studies");
        s.addTeacher(0,teacherOne);
        s.addTeacher(1,teacherTwo);
        s.addTeacher(2,teacherThree);
        //Adds teacher's respective courses to the respective ArrayList
        s.addCourses(0, teacherOne.getSubject());
        s.addCourses(1,teacherTwo.getSubject());
        s.addCourses(2,teacherThree.getSubject());

        //List out all students within the "students" ArrayList
        System.out.println("List of students:");
        s.listStudent();

        //List out all teachers within the "teachers" ArrayList
        System.out.println("\nList of teachers:");
        s.listTeacher();

        //List out all courses within the "courses" ArrayList
        System.out.println("\nList of courses:");
        s.listCourses();

        System.out.println("\nDeleting 2 students from the students list\nDeleting 1 teacher from the teachers list\n");

        //Delete 2 students from the "students" ArrayList
        s.deleteStudent(1);
        s.deleteStudent(2);

        //Delete 1 teacher from the "students" ArrayList
        s.deleteTeacher(1);

        //Prints updated ArrayList of students
        System.out.println("Updated list of students:");
        s.listStudent();

        //Prints updated ArrayList of teachers
        System.out.println("\nUpdated list of teachers:");
        s.listTeacher();

        System.out.println("\nUpdated list of courses:");
        s.listCourses();

    }
}
