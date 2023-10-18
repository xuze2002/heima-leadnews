package com.heima.user.controller.v1;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.LoginDto;
import com.heima.user.service.ApUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class Test {

    @Autowired
    private ApUserService apUserService;

    @GetMapping("/index")
    public ModelAndView test(LoginDto dto){
        ModelAndView modelAndView = new ModelAndView();

        dto.setPassword("abc");
        dto.setPhone("13511223453");

        ResponseResult responseResult = apUserService.login(dto);

        System.out.println(responseResult.getData());
        Map map=new HashMap<>();
        map.put("1","1111");
        modelAndView.addObject(map);
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
