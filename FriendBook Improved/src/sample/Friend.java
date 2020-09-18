package sample;

import javax.annotation.processing.Filer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Friend {
    //Fields
    private String name;
    private String skills;
    private String school;
    private int age;
    private int grade;

    //Constructor
    Friend(String name, int age, int grade, String skills, String school){
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.skills = skills;
        this.school = school;
    }

    //Requires: String file (name of the file being written to)
    //Modifies: file, this
    //Effects: writes name, age, grade, skills and school of friend to the indicated file
    public void writeToFile(String fileName) throws IOException{
        System.out.println("Writing to this file: " + fileName);
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + ",\r");
        bw.write(Integer.toString(age) + ",\r");
        bw.write(Integer.toString(grade) + ",\r");

        bw.write(skills + ",\r");
        bw.write(school + ",\r");
        bw.write(";\r");

        bw.close();
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    //To String Method
    public String toString(){
        return name;
    }
}
