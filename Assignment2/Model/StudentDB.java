package com.example.cpsc411assignment2.Model;

import java.util.ArrayList;

public class StudentDB {
    protected static final StudentDB ourInstance = new StudentDB();

    private ArrayList<Student> mStudentList;

    static public StudentDB getInstance() {
        return ourInstance;
    }

    private StudentDB() {
        createPersonObjects();
    }

    public ArrayList<Student> getStudentList() {
        return mStudentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        mStudentList = studentList;
    }

    public void addStudent(Student sObj){
        mStudentList.add(sObj);
    }

    protected void createPersonObjects() {
        Student student = new Student("James", "Shen", 1234567);
        ArrayList<CourseEnrollment> courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("MATH370", "B"));
        courses.add(new CourseEnrollment("CPSC223", "A"));
        student.setCourses(courses);
        mStudentList = new ArrayList<Student>();
        mStudentList.add(student);

        student = new Student("John", "Chang", 7654321);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC481", "A"));
        student.setCourses(courses);
        mStudentList.add(student);

        student = new Student("Traci", "Trojan", 2468642);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC411", "A"));
        student.setCourses(courses);
        mStudentList.add(student);
    }
}

