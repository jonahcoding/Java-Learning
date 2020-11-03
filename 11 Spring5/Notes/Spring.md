# 一、Spring简介

Spring理念：使现有技术更加容易使用，本身是一个大杂烩。

- SSH：Struct2+Spring+Hibernate
- SSM：SpringMVC+Spring+MyBatis

官网： https://spring.io/projects/spring-framework#overview

官网下载：https://repo.spring.io/release/org/springframework/spring/

Github：https://github.com/spring-projects/spring-framework

[Spring Web MVC](https://mvnrepository.com/artifact/org.springframework/spring-webmvc) **»** [5.2.5.RELEASE](https://mvnrepository.com/artifact/org.springframework/spring-webmvc/5.2.5.RELEASE)

```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.5.RELEASE</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.2.3.RELEASE</version>
</dependency>
```

- Spring是开源的免费的容器。
- Spring是轻量级的，非入侵式的。
- 控制反转（IOC），面向切面编程（AOP）。
- 支持事务处理，对框架整合的支持。

**总结：Spring是一个轻量级的控制反转（IOC）和面向切面编程（AOP）的的框架。**

# 二、IOC理论推导

1. UserDao接口

   ```java
   public interface UserDao {
       void getUser();
   }
   ```

2. UserDaoImp实现类

   ```java
   public class UserDaoImpl implements UserDao{
       public void getUser() {
           System.out.println("默认获取用户的数据！");
       }
   }
   ```

3. UserService业务接口

   ```java
   public interface UserService {
       void getUser();
   }
   ```

4. UserServiceImp业务接口实现类

   ```java
   public class UserServiceImpl implements UserService{
   
       private UserDao userDao;
   
       //以往方式：需求改变，需要在此修改源码
       //private UserDao userDao = new UserDaoImpl();
       //private UserDao userDao = new UserDaoMysqlImpl();
       //private UserDao userDao = new UserDaoOracleImpl();
   
       //注入方式：通过set接口实现
       public void setUserDao(UserDao userDao){
           this.userDao = userDao;
       }
   
       public void getUser() {
           userDao.getUser();
       }
   }
   ```

**存在的问题：用户需求可能影响原来的代码！**

**解决方案：使用一个set接口实现**

```java
    private UserDao userDao;

    //以往方式：需求改变，需要在此修改源码
    //private UserDao userDao = new UserDaoImpl();
    //private UserDao userDao = new UserDaoMysqlImpl();
    //private UserDao userDao = new UserDaoOracleImpl();

    //注入方式：利用set进行动摇实现值得注入
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
```

- 以往由程序主动创建对象，控制权在程序员手中。
- 使用set后，程序不再有主动性，变成了被动接收对象。

从本质上解决了问题，程序员不再管理对象的创建，系统的耦合度大幅降低，以更加专注于业务的实现，此即IOC原型！

![](Spring.assets/Spring_01.png)

IOC的本质：

控制反转IoC（Inversion of Control）是一种设计思想，DI（依赖注入）是现在IoC的一种方法，。对象的创建由程序控制，在控制反转后将对象的创建转移给第三方（获得依赖对象的方式反转了）

采用XML方式配置Bean的时候，Bean的定义与实现分离；而采用注解方式时二者合为一体，Bean的定义信息以注解形式定义在实现类中，从而达到零配置的目的。

**控制反转是一种通过描述（XML或注解）并通过第三方生产或获取特定对象的方式。在Spring中实现控制反转的是IoC容器，其实现方式是依赖注入（Dependency Injection，DI）。**

# 三、HelloSpring

1. 新建模块HelloSpring

2. 编写实体类Hello（pojo）

   ```java
   package com.shinrin.pojo;
   
   public class Hello {
       private String str;
       public String getStr(){
           return str;
       }
   
       public void setStr(String str){
           this.str = str;
       }
   
       @Override
       public String toString() {
           return "Hello{" +
                   "str='" + str + '\'' +
                   '}';
       }
   }
   ```

3. 配置文件bean.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
           https://www.springframework.org/schema/beans/spring-beans.xsd">
   
       <!--使用Spring来创建对象（Bean）-->
       <!--
       类型 变量名 = new 类型();
       Hello hello = new Hello();
       id = 变量名
       class = 实体类
       property 设置对象的属性值
       -->
       <bean id="hello" class="com.shinrin.pojo.Hello">
           <property name="str" value="Spring"/>
       </bean>
   </beans>
   ```

4. 测试程序

   ```java
       @Test
       public void test(){
           //获取Spring的上下文对象context
           ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
           //对象由Spring管理，使用时通过context.getBean()获取
           Hello hello = (Hello) context.getBean("hello");
           System.out.println(hello.toString());
       }
   ```

***补充：第二章中的问题，使用IOC解决***

配置文件bean.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="mysqlImpl" class="com.shinrin.dao.UserDaoMysqlImpl"/>
    <bean id="oracleImpl" class="com.shinrin.dao.UserDaoOracleImpl"/>
    <bean id="UserServiceImpl" class="com.shinrin.service.UserServiceImpl">
    <!--
        ref：引用Spring容器中创建好的对象
        value：具体的值，基本数据类型。
    -->
        <property name="userDao" ref="mysqlImpl"/>
    </bean>
</beans>
```

测试程序：

```java
    @Test
    public void test1(){
        //获取ApplicationContext，拿到Spring的容器
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //get
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");
        userServiceImpl.getUser();
    }
```

# 四、IOC创建对象的方式

1. 使用无参构造（默认）创建对象。

   ```xml
       <bean id="user" class="com.shinrin.pojo.User">
           <!--默认使用无参构造-->
           <property name="name" value="Teemo"/>
       </bean>
   ```

2. 使用有参构造创建对象。

   1. 下标赋值

      ```xml
          <bean id="user" class="com.shinrin.pojo.User">
              <constructor-arg index="0" value="Yasuo"/>
          </bean>
      ```

   2. 类型赋值（不建议使用，）

      ```xml
          <bean id="user" class="com.shinrin.pojo.User">
              <constructor-arg type="java.lang.String" value="Yasuo"/>
          </bean>
      ```

   3. 直接通过参数名赋值

      ```xml
          <bean id="user" class="com.shinrin.pojo.User">
              <constructor-arg name="name" value="Yasuo"/>
          </bean>
      ```

**bean.xml被加载后即实例化对象并保存。**

# 五、Spring设置

别名

```xml
    <!--设置别名，亦可使用别名获取对象-->
    <alias name="user" alias="U_s_e_r"/>
```

bean的配置

```xml
    <!--
    id = 对象名
    class = 类名
    name = 对象别名（可多个，逗号、空格、分号分隔）
    -->
    <bean id="userT" class="com.shinrin.pojo.User" name="user2, u2"/>
```

import

```xml
 	<!--当前文件：applicationContext.xml，应用程序中加载该文件即可-->   
	<!--合并配置文件：用于团队合作开发-->
    <import resource="bean1.xml"/>
    <import resource="bean2.xml"/>
    <import resource="bean3.xml"/>
```

# 六、DI依赖注入

1. 构造器注入

2. set方式注入（重点）
   - 依赖：bean对象的创建依赖于容器。
   - 注入：bean对象中的所有属性，由容器来注入。

**环境搭建（复杂类型）**

Student类

```java
package com.shinrin.pojo;

import java.util.*;

public class Student {
    private String name;
    private Address address;

    private String[] books;
    private List<String> hobbies;

    private Map<String, String> card;
    private Set<String> game;

    private Properties infor;
    private String wife;

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String[] getBooks() {
        return books;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public Map<String, String> getCard() {
        return card;
    }

    public Set<String> getGame() {
        return game;
    }

    public Properties getInfor() {
        return infor;
    }

    public String getWife() {
        return wife;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setCard(Map<String, String> card) {
        this.card = card;
    }

    public void setGame(Set<String> game) {
        this.game = game;
    }

    public void setInfor(Properties infor) {
        this.infor = infor;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", books=" + Arrays.toString(books) +
                ", hobbies=" + hobbies +
                ", card=" + card +
                ", game=" + game +
                ", infor=" + infor +
                ", wife='" + wife + '\'' +
                '}';
    }
}
```

Address类

```java
package com.shinrin.pojo;

public class Address {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}
```

User类

```java
package com.shinrin.pojo;

public class User {
    private String name;
    private int age;
    private Address address;

    public User() {
    }

    public User(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

**依赖注入**

配置文件（bean1.xml）

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="adddress" class="com.shinrin.pojo.Address">
        <property name="address" value="Changsha"/>
    </bean>

    <bean id="student" class="com.shinrin.pojo.Student">
        <property name="name" value="shinrin"/>
        <property name="address" ref="adddress"/>

        <property name="books">
            <array>
                <value>沙海</value>
                <value>世界</value>
                <value>防风氏</value>
            </array>
        </property>

        <property name="hobbies">
            <list>
                <value>Play</value>
                <value>Coding</value>
                <value>Music</value>
            </list>
        </property>

        <property name="card">
            <map>
                <entry key="1" value="12"/>
                <entry key="2" value="34"/>
            </map>
        </property>

        <property name="game">
            <set>
                <value>FGO</value>
                <value>LOL</value>
                <value>PUBG</value>
            </set>
        </property>

        <property name="wife">
            <null></null>
        </property>

        <property name="infor">
            <props>
                <prop key="id">1704</prop>
                <prop key="name">jonah</prop>
            </props>
        </property>

    </bean>
</beans>
```

**通过第三方注入依赖（c标签和p标签）**

依赖注入（bean2.xml）

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="addr" class="com.shinrin.pojo.Address">
        <property name="address" value="Yordel"/>
    </bean>

    <!--构造器注入-->
    <bean id="user1" class="com.shinrin.pojo.User">
        <constructor-arg index="0" value="Yasuo"/>
        <constructor-arg index="1" value="27"/>
        <constructor-arg index="2" ref="addr"/>
    </bean>
    <!--c命名空间(构造器注入)-->
    <bean id="user2" class="com.shinrin.pojo.User" c:name = "Yasuo" c:age="27" p:address-ref="addr"/>

    <!--set注入-->
    <bean id="user3" class="com.shinrin.pojo.User">
        <property name="name" value="Teemo"/>
        <property name="age" value="7"/>
        <property name="address" value="Yordel"/>
    </bean>
    <!--p命名空间注入(set注入)-->
    <bean id="user4" class="com.shinrin.pojo.User" p:name = "Teeemo" p:age="10" p:address-ref="addr"/>

</beans>
```

注：c命名空间和p命名空间。

> ```xml
>        xmlns:p="http://www.springframework.org/schema/p"
>        xmlns:c="http://www.springframework.org/schema/c"
> ```
>
> c命名空间用于构造器。
>
> p命名空间用于set注入。

**bean的作用域**

1. 单例模式（默认）

   ```xml
       <!--单例模式-->
       <bean id="user2" class="com.shinrin.pojo.User" c:name = "Yasuo" c:age="27" p:address-ref="addr" scope="singleton"/>
   ```

2. 原型模式：每次get时都产生一个新对象。

   ```xml
       <!--原型模式-->
       <bean id="user2" class="com.shinrin.pojo.User" c:name = "Yasuo" c:age="27" p:address-ref="addr" scope="prototype"/>
   ```

3. 其余request、session、application只在web开发中使用。

   

# 七、bean的自动装配

- 自动装配是Spring满足bean依赖的一种方式。
- Spring会在上下文自动查找，并自动给bean装配属性。

Spring中三种装配的方式：

1. 在xml中显式配置
2. 在java中显式配置
3. 隐式自动装配【重要】

## 7.1 环境搭建

一人一喵一汪

Cat类

```java
public class Cat {
    public void bray(){
        System.out.println("cat meow。。。");
    }
}
```

Dog类

```java
public class Dog {
    public void bray(){
        System.out.println("Barking...");
    }
}
```

Person类

```java
package com.shinrin.pojo;

public class Person {
    private Cat cat;
    private Dog dog;
    private String name;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}
```

## 7.2 使用xml自动装配

beans.xml

```xml
    <bean id="cat" class="com.shinrin.pojo.Cat"/>
    <bean id="dog11" class="com.shinrin.pojo.Dog"/>

    <!--byName自动查找和对象set对应的值相对应的id-->
    <!--<bean id="person" class="com.shinrin.pojo.Person" autowire="byName">-->
        <!--<property name="name" value="shinrin"/>-->
    <!--</bean>-->

    <!--byType自动查找和对象属性相同的bean-->
    <bean id="person" class="com.shinrin.pojo.Person" autowire="byType">
        <property name="name" value="shinrin"/>
    </bean>
```

- **byName自动装配：自动查找与对象set对应的值（属性名）相对应的id（bean）**

- **byType自动装配：自动查找与对象属性（类型）相同的bean**



## 7.3 使用注解自动装配

1. 导入context约束

   ```xml
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:context="http://www.springframework.org/schema/context"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
           https://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context
           https://www.springframework.org/schema/context/spring-context.xsd">
   
       <context:annotation-config/>
   	<!--some beans...-->
   </beans>
   ```

2. @Autowire

   1. @Autowired通过byType实现，默认要求对象必须存在。
   2. 通过@Autowired(required = false)以允许对象不存在（为null值）。
   3. 如果有多个对象，使用 @Qualifier(value = "cat11")以指定唯一的id对象。

3. @Resource
   1. @Resource默认通过byName实现，未指定name和type时，按byName（属性名）查找匹配，无匹配时回退至原始类型（属性类型）通过byType查找，如匹配则自动装配。
   2. 如同时指定name和type，则在上下文中查询唯一匹配装配，未果抛出异常。
   3. 如只指定name，则在上下文中查询名称（id）匹配的bean装配，未果抛出异常。
   4. 如只指定type，则在上下文中查询类型匹配的唯一bean装配，无匹配或多个匹配抛出异常。

4. beans.xml

   ```xml
       <bean id="cat" class="com.shinrin.pojo.Cat"/>
       <bean id="cat11" class="com.shinrin.pojo.Cat"/>
   
       <bean id="dog" class="com.shinrin.pojo.Dog"/>
       <bean id="dog11" class="com.shinrin.pojo.Dog"/>
       <bean id="dog22" class="com.shinrin.pojo.Dog"/>
   ```

5. 实体类

   ```java
       //默认byType实现，要求对象必须存在
       //指定参数required = false以允许对象为null
       @Autowired(required = false)
       //有多个对象时，按bean的id查找
       @Qualifier(value = "cat11")
       private Cat cat;
   
       //默认byName实现，查询未果时再按byType查找
       @Resource(name = "dog11")
       private Dog dog;
   ```

八、使用注解开发





















