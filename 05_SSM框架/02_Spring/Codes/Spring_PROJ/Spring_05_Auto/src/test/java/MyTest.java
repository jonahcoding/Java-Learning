import com.shinrin.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    //自动装配：Autowired/Resource
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }

    //自动装配：byName
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }

    //自动装配：byType
    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }
}
