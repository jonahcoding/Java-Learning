import com.shinrin.dao.UserMapper;
import com.shinrin.pojo.User;
import com.shinrin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void getAllUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //查询所有用户
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //通过ID查询用户
        User userById = mapper.getUserById(1);
        System.out.println(userById);

        sqlSession.close();
    }

    @Test
    public void addUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //添加用户
        mapper.addUser(new User(5, "Annie", "solo"));
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void updateUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //更新用户
        mapper.updateUser(new User(4, "Jax", "Street lamp"));

        sqlSession.close();
    }

    @Test
    public void deleteUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //删除用户
        mapper.deleteUser(2);

        sqlSession.close();
    }


}
