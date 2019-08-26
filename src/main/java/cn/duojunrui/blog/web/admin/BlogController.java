package cn.duojunrui.blog.web.admin;

import cn.duojunrui.blog.entity.Blog;
import cn.duojunrui.blog.service.BlogService;
import cn.duojunrui.blog.service.TagService;
import cn.duojunrui.blog.service.TypeService;
import cn.duojunrui.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Duojunrui
 * @Date: 2019/8/18 16:17
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    public final static String LIST = "/admin/blogs";
    public final static String ADD = "/admin/blogs_add";
    public final static String REDIRT = "/admin/blogs";

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size = 2, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        BlogQuery blog, Model model) {
        model.addAttribute("page", blogService.listBlog(blog, pageable));
        model.addAttribute("types",typeService.listType());
        return LIST;
    }

    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size = 2, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                         BlogQuery blog, Model model) {
        model.addAttribute("page", blogService.listBlog(blog, pageable));
        return "/admin/blogs :: blogList";
    }

    @GetMapping("/blogs/add")
    public String add(Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags",tagService.listTag());
        model.addAttribute("blog",new Blog());
        return ADD;
    }

    public String post(){
        //TODO
        return null;
    }
}
