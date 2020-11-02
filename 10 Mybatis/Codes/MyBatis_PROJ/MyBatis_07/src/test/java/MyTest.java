import com.shinrin.dao.UsersMapper;
import com.shinrin.pojo.Users;
import com.shinrin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        Users user1 = mapper.queryUserById(1);
        System.out.println(user1);
        //mapper.updateUser(new Users(1, "teemo", "123456"));
        sqlSession.clearCache();
        Users user2 = mapper.queryUserById(1);
        System.out.println(user2);
        System.out.println(user1 == user2);
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        UsersMapper mapper2 = sqlSession2.getMapper(UsersMapper.class);

        Users user = mapper.queryUserById(1);
        System.out.println(user);
        //sqlSession.close();//true，使用了二级缓存

        System.out.println("===============================");

        Users user2 = mapper2.queryUserById(1);
        System.out.println(user);

        System.out.println(user == user2);
        sqlSession.close();//false，一级缓存
        sqlSession2.close();
    }
}
