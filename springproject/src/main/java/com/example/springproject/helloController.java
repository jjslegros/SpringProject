package com.example.springproject;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class helloController {

    @RequestMapping("/")
    public String index() {
        return "hello";

    }
    
	

}