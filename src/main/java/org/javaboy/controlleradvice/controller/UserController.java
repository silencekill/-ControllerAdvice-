package org.javaboy.controlleradvice.controller;


import org.javaboy.controlleradvice.entity.Author;
import org.javaboy.controlleradvice.entity.Book;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
public class UserController {

    /**
     * 处理异常测试
     * @param age
     * @return
     */
    @GetMapping("hello")
    public String get(Integer age){
        if(age>10){
            throw new RuntimeException("");
        }
        return "hello";
    }

    /**
     * 预设全局数据测试
     * @param model
     */
    @GetMapping("globalData")
    public void globalData(Model model){
        Map<String, Object> map = model.asMap();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key+":"+map.get(key));
        }
    }


    @PostMapping("param")
    public void param(@ModelAttribute("b") Book book, @ModelAttribute("a") Author author){
        System.out.println(book);
        System.out.println(author);
    }
}
