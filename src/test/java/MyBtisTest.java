import com.hnust.pojo.Course;
import com.hnust.pojo.School;
import com.hnust.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.awt.*;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * Created by 23222 on 2023/3/27.
 */
public class MyBtisTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void init() {
        //定义读取文件名
        String resources = "mybatis-config.xml";
        //创建流
        Reader reader = null;
        try {
            //读取mybatis-config.xml文件到reader对象中
            reader = Resources.getResourceAsReader(resources);
            //初始化mybatis,创建SqlSessionFactory类的对象
            SqlSessionFactory sqlMapper = new
                    SqlSessionFactoryBuilder().build(reader);
            //创建session对象
            sqlSession = sqlMapper.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findCourseById2(){
      //  SqlSession session = MyBatisUtils.getSession();
        Course course=sqlSession.selectOne("com.hnust.mapper.CourseMapper.findCourseById",2);
        System.out.println(course.toString());

    }

    @Test
    public void findCourseById1(){
            Course course=sqlSession.selectOne("com.hnust.mapper.CourseMapper.findCourseById",1);
            System.out.println(course);
    }

    @Test
    public void updateCourseById(){
        Course course=new Course();
        course.setId(4);
        course.setName("高级Web技术");
        course.setHours(40);
        course.setSid("1");
        int result = sqlSession.update("com.hnust.mapper.CourseMapper.updateCourse", course);
        if (result > 0) {
            System.out.println("成功更新" + result + "条数据");
        } else {
            System.out.println("更新数据失败");
        }
        System.out.println(course.toString());
    }

    @Test
    public void addCourse() {
        Course course = new Course();
        course.setId(5);
        course.setName("大数据存储");
        course.setHours(32);
        course.setSid("1");
        int result = sqlSession.insert("com.hnust.mapper.CourseMapper.addCourse",course );
        if (result > 0) {
            System.out.println("成功插入" + result + "条数据");
        } else {
            System.out.println("插入数据失败");
        }
        System.out.println(course.toString());
    }

    @Test
    public void findCourseByAll(){
        School school=sqlSession.selectOne("com.hnust.mapper.SchoolMapper.findSchoolWithCourse",1);
        System.out.println(school.toString());
        School school2=sqlSession.selectOne("com.hnust.mapper.SchoolMapper.findSchoolWithCourse",2);
        System.out.println(school2.toString());
    }

    @After
    public void destory() {
        //提交事务
        sqlSession.commit();
        //关闭事务
        sqlSession.close();
    }
}

