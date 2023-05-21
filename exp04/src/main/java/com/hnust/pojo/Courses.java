package com.hnust.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by 23222 on 2023/4/4.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
     private int  id;
     private String name;
     private int hours;
     private String school;

}
