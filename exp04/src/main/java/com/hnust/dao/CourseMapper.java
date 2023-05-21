package com.hnust.dao;

import com.hnust.pojo.Courses;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 23222 on 2023/4/4.
 */
public interface CourseMapper {

    int addCourse(Courses course);

    int deleteCourseById(@Param("id") int id);

    int updateCourse(Courses course);

     Courses queryCourseById(@Param("id") int id);

     List<Courses> queryAllCourse();

     List<Courses> queryCourseName(String name);

}
