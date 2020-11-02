import com.shinrin.pojo.Hello;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test(){
        //获取Spring的上下文对象context
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //对象由Spring管理，使用时通过context.getBean()获取
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}
