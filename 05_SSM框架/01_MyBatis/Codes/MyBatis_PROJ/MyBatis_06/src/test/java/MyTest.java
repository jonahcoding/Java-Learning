import com.shinrin.dao.BlogMapper;
import com.shinrin.pojo.Blog;
import com.shinrin.utils.IDUtils;
import com.shinrin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void addInitBlogTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog1 = new Blog();
        blog1.setId(IDUtils.getId());
        blog1.setTitle("Python");
        blog1.setAuthor("python");
        blog1.setCreateTime(new Date());
        blog1.setViews(9999);

        Blog blog2 = new Blog();
        blog2.setId(IDUtils.getId());
        blog2.setTitle("C++");
        blog2.setAuthor("c++");
        blog2.setCreateTime(new Date());
        blog2.setViews(9999);

        Blog blog3 = new Blog();
        blog3.setId(IDUtils.getId());
        blog3.setTitle("JAVA");
        blog3.setAuthor("java");
        blog3.setCreateTime(new Date());
        blog3.setViews(9999);

        Blog blog4 = new Blog();
        blog4.setId(IDUtils.getId());
        blog4.setTitle("C");
        blog4.setAuthor("c");
        blog4.setCreateTime(new Date());
        blog4.setViews(9999);

        Blog blog5 = new Blog();
        blog5.setId(IDUtils.getId());
        blog5.setTitle("C#");
        blog5.setAuthor("c#");
        blog5.setCreateTime(new Date());
        blog5.setViews(9999);

        mapper.addBlog(blog1);
        mapper.addBlog(blog2);
        mapper.addBlog(blog3);
        mapper.addBlog(blog4);
        mapper.addBlog(blog5);

        sqlSession.close();
    }

    @Test
    public void queryBlogIfTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();
        hashMap.put("title", "JAVA");//注释此条语句将报错
        hashMap.put("author", "shinrin");

        List<Blog> blogs = mapper.queryBlogIF(hashMap);
        for (Blog blog : blogs){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogChooseTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();
        //hashMap.put("title", "JAVA");//只执行第一个
        hashMap.put("author", "jonah");

        List<Blog> blogs = mapper.queryBlogIF(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlogTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();

        hashMap.put("title", "c");
        hashMap.put("author", "jonah");
        hashMap.put("id", "2cd723a6d9d54d098d1ec0f4d5babac9");

        mapper.updateBlog(hashMap);
        sqlSession.close();
    }

    @Test
    public void queryBlogForeachTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        HashMap hashMap = new HashMap();
        hashMap.put("ids", ids);

        List<Blog> blogs = mapper.queryBlogForeach(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

}
