package com.hnust.pojo;

import java.util.List;

/**
 * Created by 23222 on 2023/3/27.
 */
public class School {
    private int id;
    private String schoolName;
    private List<Course> course;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                ", course=" + course +
                '}';
    }
}
