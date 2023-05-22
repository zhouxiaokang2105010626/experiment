package com.hnust.service;

import com.hnust.pojo.Courses;
import com.hnust.pojo.User;

import java.util.List;

/**
 * Created by 23222 on 2023/4/4.
 */
public interface CourseService {

    void register(User user);

    User login(User user);

    int addCourse(Courses course);

    int deleteCourseById( int id);

    int updateCourse(Courses course);

    Courses queryCourseById(int id);

    List<Courses> queryAllCourse();

    List<Courses> queryCourseName(String name);

}
