import com.shinrin.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test(){
        //User user = new User();
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //User user = (User) context.getBean("U_s_e_r");
        //User user = (User) context.getBean("userT");
        User user = (User) context.getBean("u2");
        user.show();

    }
}
