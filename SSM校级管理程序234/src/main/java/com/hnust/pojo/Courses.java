package com.hnust.pojo;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 23222 on 2023/4/4.
 */

public class Courses {
     private int  id;
     private String name;
     private String img;
     private int hours;
     private String school;
     private MultipartFile file;

     public Courses(){

     }

     public Courses(int id, String name, String img, int hours, String school, MultipartFile file) {
          this.id = id;
          this.name = name;
          this.img = img;
          this.hours = hours;
          this.school = school;
          this.file = file;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getImg() {
          return img;
     }

     public void setImg(String img) {
          this.img = img;
     }

     public int getHours() {
          return hours;
     }

     public void setHours(int hours) {
          this.hours = hours;
     }

     public String getSchool() {
          return school;
     }

     public void setSchool(String school) {
          this.school = school;
     }

     public MultipartFile getFile() {
          return file;
     }

     public void setFile(MultipartFile file) {
          this.file = file;
     }
}
