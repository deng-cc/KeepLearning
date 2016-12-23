package com.atguigu.bk.controller;

import com.atguigu.bk.biz.BookBiz;
import com.atguigu.bk.entity.TBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookAction {

    @RequestMapping("/main")
    //todo index.jsp中跳转/book/main.do，出发dispatcherServlet;
    //todo 地址默认交给beanNameUrlHandlerMapping处理，去找/开头的bean，即找到了此处的/book/main?
    //todo 所以，是哪里默认的 .do可以被消掉？经验证，也可以是@RequestMapping("/main.do")
    public String getAllBooks(Model model) {
        String result = null;

        BookBiz biz = new BookBiz();
        try {
            List<TBook> books = biz.getAllBooks();
            model.addAttribute("books", books);
            //hint: 比对servlet --> request.setAttribute("books",books);
            result = "/main/main.jsp";
            //hint: 返回一个逻辑视图名，由视图解析器进行解析到具体的页面，spring-mvc.xml配置
        } catch (Exception e) {
            model.addAttribute("msg", "网络异常，请和管理员联系");
            result = "/error.jsp";
        }

        return result;
    }
}
