package com.atguigu.bk.controller;

import com.atguigu.bk.biz.BookBiz;
import com.atguigu.bk.entity.TBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/back")
public class BackAction {

    /**
     * GET请求到达书籍添加页面
     * @return
     */
    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String addBook() {
        return "/back/BookAdd.jsp";
    }


    /**
     * 图书上架功能
     * @param book
     * @return
     */
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    //hint：关于springMVC中的文件上传处理，使用MultipartFile file
    public String addBook(TBook book, Model model,@RequestParam("pic2") MultipartFile file) { //hint：相当于基本数据和字节流分开，各自传递
        String result = null;
        if (book != null) {
            BookBiz bookbiz = new BookBiz();
            try {
                if (file != null && !file.isEmpty()) {
                    //将byte[]的图片信息传入到book中
                    byte[] bytes = file.getBytes();
                    book.setPic(bytes);
                }
                bookbiz.addBook(book);
                model.addAttribute("msg", book.getBname() + "--录入成功");
                result = "/back/BookAdd.jsp";
            } catch (Exception e) {
                model.addAttribute("msg", e.getMessage());
                result = "/error.jsp";
            }
        }
        return result;
    }
}
