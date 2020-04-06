package org.javaboy.controlleradvice.advice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalData {

    @ModelAttribute(value = "globalInfo")
    public Map<String,Object> myData(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","张");
        map.put("age",18);
        return map;
    }

    @InitBinder("a")
    public void initA(WebDataBinder binder){
        // 给别名为a的对象添加前缀
        binder.setFieldDefaultPrefix("a.");
    }

    @InitBinder("b")
    public void initB(WebDataBinder binder){
        // 给别名为b的对象添加前缀
        // 前端在传值得时候 属性前需要加上对应的前缀
        binder.setFieldDefaultPrefix("b.");
    }
}
