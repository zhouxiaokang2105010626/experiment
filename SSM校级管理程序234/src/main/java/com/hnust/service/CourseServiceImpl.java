package com.hnust.service;
import com.hnust.dao.CourseMapper;
import com.hnust.pojo.Courses;
import com.hnust.pojo.User;

import java.util.List;

/**
 * Created by 23222 on 2023/4/4.
 */

public class CourseServiceImpl implements CourseService {

    private CourseMapper courseMapper;

    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public void register(User user){
        courseMapper.register(user);
    }

    @Override
    public User login(User user){
        return courseMapper.login(user);
    }

    @Override
    public int addCourse(Courses course) {
        System.out.println(course);
        return courseMapper.addCourse(course);
    }

    @Override
    public int deleteCourseById(int id) {
        return courseMapper.deleteCourseById(id);
    }

    @Override
    public int updateCourse(Courses course) {
        System.out.println(course);
        return courseMapper.updateCourse(course);
    }

    @Override
    public Courses queryCourseById(int id) {
        return courseMapper.queryCourseById(id);
    }

    @Override
    public List<Courses> queryAllCourse() {
        return courseMapper.queryAllCourse();
    }

    @Override
    public List<Courses> queryCourseName(String name) {
        return courseMapper.queryCourseName(name);
    }
}
