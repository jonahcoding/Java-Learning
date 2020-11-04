import com.shinrin.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.query();
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }

    @Test
    public void test3(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.delete();
    }
}
