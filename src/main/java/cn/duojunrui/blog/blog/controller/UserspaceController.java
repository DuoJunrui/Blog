package cn.duojunrui.blog.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户主页 控制器
 *
 * @className: UserspaceController
 * @author: Duojunrui
 * @date: 2019-04-26 22:03
 */
@Controller
@RequestMapping("/u")
public class UserspaceController {

    @GetMapping("/{username}")
    public String userSpace(@PathVariable("username") String username) {
        return "/userspace/u";
    }

    @GetMapping("/{username}/blogs")
    public String listBlogsByOrder(@PathVariable("username") String username,
                                   @RequestParam(value = "order" , required = false, defaultValue = "new") String order,
                                   @RequestParam(value = "category" , required = false) Long category,
                                   @RequestParam(value = "keyword" , required = false) String keyword) {
        if (category != null) {
            return "/userspace/u";
        }else if (keyword!=null && keyword.isEmpty()==false){
            return "/userspace/u";
        }
        return "/userspace/u";
    }

    @GetMapping("/{username}/blogs/{id}")
    public String listBlogsByOrder(@PathVariable("id") Long id){
        return "/userspace/blog";
    }

    @GetMapping("/{username}/blogs/edit")
    public String editBlog(){
        return "/userspace/blogedit";
    }
}
