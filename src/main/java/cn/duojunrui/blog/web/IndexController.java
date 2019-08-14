package cn.duojunrui.blog.web;

import cn.duojunrui.blog.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/14 23:29
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
//        int i = 9/0;
        String blog = null;
        if (blog == null) {
            throw new NotFoundException("博客不存在");
        }
        return "index";
    }
}
