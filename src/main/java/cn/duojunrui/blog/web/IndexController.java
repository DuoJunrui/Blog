package cn.duojunrui.blog.web;

import cn.duojunrui.blog.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/14 23:29
 */
@Controller
public class IndexController {

    @GetMapping("/{id}/{name}")
    public String index(@PathVariable String id, @PathVariable String name) {
//        int i = 9/0;
//        String blog = null;
//        if (blog == null) {
//            throw new NotFoundException("博客不存在");
//        }

        System.out.println("--------index-----------");
        return "index";
    }
}
