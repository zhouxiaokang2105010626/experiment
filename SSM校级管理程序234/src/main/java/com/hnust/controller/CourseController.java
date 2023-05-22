package com.hnust.controller;

import com.hnust.dao.CourseMapper;
import com.hnust.pojo.Courses;
import com.hnust.pojo.User;
import com.hnust.pojo.location;
import com.hnust.service.CourseService;
import com.hnust.service.CourseServiceImpl;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;

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

    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }
   /* @RequestMapping("/login")
    public String login(User user, HttpServletRequest request){
        User user1=courseService.login(user);
        if(user1!=null){
            request.getSession().setAttribute("USER_SESSION",user1);
            return "redirect:/course/allcourse";
        }else {
            request.setAttribute("msg", "邮箱密码错误");
            return "login";
        }
    }*/
   @RequestMapping("/login")
   public String login(User user, HttpServletRequest request, String code){
       HttpSession session = request.getSession();
       System.out.println("我的code是  "+code);
       String correctCode = (String) session.getAttribute("code");
       System.out.println("正确的code是  "+correctCode);
       if (code != null && code.equalsIgnoreCase(correctCode)) {
           User user1=courseService.login(user);
           if(user1!=null){
               session.setAttribute("USER_SESSION",user1);
               return "redirect:/course/allcourse";
           }else {
               request.setAttribute("msg", "邮箱密码错误");
               return "login";
           }
       } else {
           request.setAttribute("msg", "验证码错误");
           return "login";
       }
   }

    @RequestMapping("/register1")
    public String register(User user, HttpServletRequest request, String code){
        HttpSession session = request.getSession();
        System.out.println("我的code是  "+code);
        String correctCode = (String) session.getAttribute("code");
        System.out.println("正确的code是  "+correctCode);
        if (code != null && code.equalsIgnoreCase(correctCode)) {
            courseService.register(user);
            return "login";
        } else {
            request.setAttribute("msg", "验证码错误");
            return "register1";
        }

    }


    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:tologin";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/register")
    public void register(User user){
            courseService.register(user);
    }





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
        MultipartFile file= courses.getFile();
        if(file!=null){
            String originalFileName= file.getOriginalFilename();
//            String suffix=originalFileName.substring(originalFileName.indexOf("."));
            String suffix = "";
            if (originalFileName.contains(".")) {
                suffix = originalFileName.substring(originalFileName.lastIndexOf('.'));
            }
            String fileName= UUID.randomUUID().toString()+suffix;
            String filePath= location.IMG_PATH+fileName;
            File saveFile=new File(filePath);
            try{
                file.transferTo(saveFile);
                courses.setImg(fileName);
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            // 当 course.getFile() 为空时，使用默认图片代替
            String defaultImagePath = "D:\\workspace\\JavaWorkspace\\IDEA\\experiment\\exp02 - SSM校级管理程序noLogin\\src\\main\\webapp\\images1\\default.png";
            File defaultImageFile = new File(defaultImagePath);
            String defaultImageName = defaultImageFile.getName();
            courses.setImg(defaultImageName);

        }
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
    public String updatebook(Courses course) throws IOException {
        MultipartFile file= course.getFile();
        if(file!=null){
            String originalFileName= file.getOriginalFilename();
            String suffix=originalFileName.substring(originalFileName.indexOf("."));
            String fileName= UUID.randomUUID().toString()+suffix;
            String filePath=location .IMG_PATH+fileName;
            File saveFile=new File(filePath);
            try{
                file.transferTo(saveFile);
                course.setImg(fileName);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        courseService.updateCourse(course);
        return "redirect:/course/allcourse";
    }
/*
@RequestMapping("/updatecourse")
    public String updatebook(Courses course) {
        MultipartFile file = course.getFile();
        if (file != null) {
            // 上传非空图片的处理逻辑
            String originalFileName = file.getOriginalFilename();
            String suffix = "";
            if (originalFileName.contains(".")) {
                suffix = originalFileName.substring(originalFileName.lastIndexOf('.'));
            }
            String fileName = UUID.randomUUID().toString() + suffix;
            String filePath = location.IMG_PATH + fileName;
            File saveFile = new File(filePath);
            try {
                file.transferTo(saveFile);
                course.setImg(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // 上传空图片的处理逻辑，使用默认图片
            String defaultImagePath = "D:\\workspace\\JavaWorkspace\\IDEA\\experiment\\exp02 - SSM校级管理程序noLogin\\src\\main\\webapp\\images1\\default.png";
            File defaultImageFile = new File(defaultImagePath+".png");
            String defaultImageName = defaultImageFile.getName();
            course.setImg(defaultImageName);
        }

        courseService.updateCourse(course);
        return "redirect:/course/allcourse";
    }



 */
    
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
