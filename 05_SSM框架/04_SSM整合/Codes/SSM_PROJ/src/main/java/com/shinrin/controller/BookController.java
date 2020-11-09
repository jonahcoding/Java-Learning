package com.shinrin.controller;

import com.shinrin.pojo.Books;
import com.shinrin.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller 调 service 层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部书籍，并返回一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddPaper")
    public String toAddPaper(){
        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addPaper(Books books){
        bookService.addBook(books);
        return "redirect:/book/allBook";//重定向至@RequestMapping("/allBook")的请求
    }

    //跳转到修改页面
    @RequestMapping("/toUpdatePaper")
    private String toUpdatePaper(int id, Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBooks", books);
        return "updateBook";
    }

    //修改书籍的请求
    @RequestMapping("/updateBook")
    public String updatePaper(Books books){
        System.out.println("updateBook=>" + books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";//重定向至@RequestMapping("/allBook")的请求
    }

    //删除书籍
    @RequestMapping("/deleteBook/{bookId}")
    public String deletePaper(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";//重定向至@RequestMapping("/allBook")的请求
    }

    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model){
        Books books = bookService.queryBookByName(queryBookName);

        System.err.println("queryBook=>" + books);

        List<Books> list = new ArrayList<Books>();
        list.add(books);

        if (books == null){
            list = bookService.queryAllBook();
            model.addAttribute("error", "查询未果");
        }

        model.addAttribute("list", list);
        return "allBook";
    }

}
