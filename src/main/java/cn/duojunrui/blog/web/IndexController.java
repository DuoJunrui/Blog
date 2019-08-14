package cn.duojunrui.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/14 23:29
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        int i = 9/0;
        return "index";
    }
}
