package com.example.cpsc411assignment2.Model;

import java.util.ArrayList;

public class CourseEnrollment {

    protected String mCourseID;
    protected String mGrade;

    protected ArrayList<CourseEnrollment> mCourses;

    public CourseEnrollment(String courseID, String grade) {
        mCourseID = courseID;
        mGrade = grade;
    }

    public String getCourseID() {
        return mCourseID;
    }

    public void setCourseID(String courseID) {
        mCourseID = courseID;
    }

    public String getGrade() {
        return mGrade;
    }

    public void setGrade(String grade) {
        mGrade = grade;
    }

    public ArrayList<CourseEnrollment> getCourses() {
        return mCourses;
    }

    public void setCourses(ArrayList<CourseEnrollment> courses) {
        mCourses = courses;
    }
}
