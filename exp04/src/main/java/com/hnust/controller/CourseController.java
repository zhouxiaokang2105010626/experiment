package com.hnust.controller;

import com.hnust.dao.CourseMapper;
import com.hnust.pojo.Courses;
import com.hnust.service.CourseService;
import com.hnust.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 23222 on 2023/4/4.
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    //controller调service
    @Autowired
    @Qualifier("CourseServiceImpl")
    private CourseService courseService;

    @RequestMapping("/allcourse")
    public String list(Model model){
        List<Courses> courses =courseService.queryAllCourse();
        model.addAttribute("list",courses);
        return "allcourse";
    }

    @RequestMapping("/toAddCourse")
    public String toAddCourse(){
        return "addcourse";
    }


    @RequestMapping("/addcourse")
    public String addcourses(Courses courses){
        System.out.println("addcourses==> "+courses);
        courseService.addCourse(courses);
        return "redirect:/course/allcourse"; //重定向到allbook实现页面的复用
    }

    @RequestMapping("/toupdate")
    public String toupdate(int id,Model model){
        System.out.println("ID------->>>>"+id);
        Courses courses = courseService.queryCourseById(id);
        model.addAttribute("lists",courses);
        return "updatecourse";
    }

    @RequestMapping("/updatecourse")
    public String updatebook(Courses course){
        courseService.updateCourse(course);
        return "redirect:/course/allcourse";
    }

    @RequestMapping("/deletecourse/{id}")
    public String deletebook(@PathVariable("id") int id){
        courseService.deleteCourseById(id);
        return "redirect:/course/allcourse";
    }

    @RequestMapping("/querycoursename")
    public String querycoursename(String name,Model model) {
        List<Courses> courses = courseService.queryCourseName(name);
        model.addAttribute("list", courses);
        if (courses.size() == 0) {
//            model.addAttribute("list", courseService.queryAllCourse());
            model.addAttribute("error","未查到");
        }
        return "allcourse";
    }

    }
