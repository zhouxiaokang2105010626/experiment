import com.hnust.pojo.Courses;
import com.hnust.service.CourseService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 23222 on 2023/4/4.
 */


public class MyTest {
    @Test
    public void test(){

        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseService courseServiceImpl = (CourseService) context.getBean("CourseServiceImpl");
          Courses courses =courseServiceImpl.queryCourseById(1);
            System.out.println(courses);

    }


}
