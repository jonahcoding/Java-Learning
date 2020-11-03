import com.shinrin.pojo.Student;
import com.shinrin.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }

    //构造器注入
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        User user = (User) context.getBean("user1");
        System.out.println(user);
    }

    //构造器注入（c命名空间）
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        User user = (User) context.getBean("user2");
        System.out.println(user);
    }

    //set注入
    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        User user = (User) context.getBean("user3");
        System.out.println(user);
    }

    //set注入（p命名空间）
    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        User user = (User) context.getBean("user4");
        System.out.println(user);
    }

    //单例模式
    @Test
    public void test5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        User user1 = (User) context.getBean("user5");
        User user2 = (User) context.getBean("user5");
        System.out.println("user1 == user2  ?  " + (user1 == user2));
    }

    //原型模式
    @Test
    public void test6(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        User user1 = (User) context.getBean("user6");
        User user2 = (User) context.getBean("user6");
        System.out.println("user1 == user2  ?  " + (user1 == user2));
    }
}
