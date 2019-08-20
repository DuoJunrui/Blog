package cn.duojunrui.blog.web.admin;

import cn.duojunrui.blog.entity.Type;
import cn.duojunrui.blog.service.TypeService;
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
 * @Date: 2019/8/19 0:05
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(@PageableDefault(size = 3, sort = {"id"}, direction = Sort.Direction.DESC)
                                Pageable pageable, Model model) {
        model.addAttribute("page", typeService.listType(pageable));
        return "/admin/types";
    }

    @GetMapping("/types/add")
    public String add() {
        return "/admin/types_add";
    }

    @PostMapping("/types")
    public String save(Type type) {
        Type newType = typeService.saveType(type);
        if (newType == null) {

        } else {

        }
        return "redirect:/admin/types";
    }
}
