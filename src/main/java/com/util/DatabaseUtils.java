package com.util;

import com.entity.Course;
import com.entity.Teacher;
import com.entity.Title;

import java.time.LocalDateTime;
import java.util.List;

public class DatabaseUtils {
    private static List<Teacher> teachers;
    private static List<Course> courses;
    private static List<Title> titles;

    static{
        Title title01 = new Title(01,"讲师");
        Title title02 = new Title(02,"副教授");
        Title title03 = new Title(03,"教授");
        titles = List.of(title01,title02,title03);

        Course course01 = new Course(01,"Web开发技术");
        Course course02 = new Course(02,"Java程序设计");
        Course course03 = new Course(03,"数据库原理");
        Course course04 = new Course(04,"软件项目管理");
        courses = List.of(course01,course02,course03,course04);

        var time01 = LocalDateTime.of(2019,7,8, 9,25);
        var time02 = LocalDateTime.of(2020,12,4, 15,30);

        Teacher teacher01 = new Teacher(01,"唐晨阳",List.of(course01,course02),title03,time01);
        Teacher teacher02 = new Teacher(02,"刘桃枝",List.of(course02,course03),title02,time02);
        teachers = List.of(teacher01,teacher02);
    }
    public static List<Title> listTitles(){
        return titles;
    }
    public static List<Course> listCourses(){
        return courses;
    }
    public static List<Teacher> listTeachers(){
        return teachers;
    }
    public static Teacher getTeacher(int id){
        for(Teacher teacher : teachers){
            if(teacher.getId() == id){
                return teacher;
            }
        }
        return null;
    }
}
