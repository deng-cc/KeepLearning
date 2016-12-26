package com.atguigu.bk.controller;

import com.atguigu.bk.biz.BookBiz;
import com.atguigu.bk.entity.TBook;
import com.atguigu.bk.util.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookAction {

    /**
     * 主页显示，所有图书信息
     * @param model
     * @return
     */
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

    @RequestMapping("/pic")
    @ResponseBody
    //hint: 方法返回的数据直接写到http body中，返回的不是view的名字
    //hint: 通过@RequestParam("xxx")的方式，让xxx和形参产生联系（如果请求中的参数和方法参数名一致，则不需要）
    public byte[] getBookPic(@RequestParam("isbn") String isbn, HttpServletRequest request) {
        byte[] pic = null;
        if (isbn != null) {
            BookBiz biz = new BookBiz();
            try {
                pic = biz.getBookPic(isbn);
            } catch (Exception e) {
                Log.logger.error(e.getMessage());
            }
        } else {
            request.setAttribute("msg", "isbn不能为null");
        }

        return pic;
    }
}
