import com.shinrin.mapper.UserMapper;
import com.shinrin.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = (UserMapper) context.getBean("userMapper1");
        List<User> users = mapper.selectUser();
        System.out.println(users);
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper = (UserMapper) context.getBean("userMapper2");
        List<User> users = mapper.selectUser();
        System.out.println(users);
    }
}
