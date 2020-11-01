package com.shinrin.dao;

import com.shinrin.pojo.Blog;

import java.util.List;
import java.util.Map;
@SuppressWarnings("all")
public interface BlogMapper {
    //插入博客
    int addBlog(Blog blog);

    //查询博客
    List<Blog> queryBlogIF(Map map);

    //查询博客
    List<Blog> queryBlogChoose(Map map);

    //更新博客
    int updateBlog(Map map);

    //froeach
    List<Blog> queryBlogForeach(Map map);

}
