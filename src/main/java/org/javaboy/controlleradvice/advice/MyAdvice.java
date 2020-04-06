package org.javaboy.controlleradvice.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class MyAdvice {

    // 通过response流写到页面
    /*@ExceptionHandler(Exception.class)
    public void myException(Exception e, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write("出现异常");
        out.flush();
        out.close();
    }*/

    // 返回ModelAndView
    @ExceptionHandler(Exception.class)
    public ModelAndView myException(Exception e, HttpServletResponse response) throws IOException {
        ModelAndView view = new ModelAndView();
        view.setViewName("error");
        view.addObject("msg","出现异常");
        return view;
    }
}
