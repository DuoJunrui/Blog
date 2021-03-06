package cn.duojunrui.blog.web.admin;

import cn.duojunrui.blog.entity.Type;
import cn.duojunrui.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
    public String add(Model model) {
        model.addAttribute("type", new Type());
        return "/admin/types_add";
    }

    @GetMapping("/types/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "/admin/types_add";
    }

    @PostMapping("/types")
    public String save(@Valid Type type, BindingResult result, RedirectAttributes attributes) {
        Type types = typeService.getTypeByName(type.getName());
        if (types != null) {
            result.rejectValue("name", "nameError", "分类名称重复，添加失败！");
        }
        if (result.hasErrors()) {
            return "/admin/types_add";
        }
        Type newType = typeService.saveType(type);
        if (newType == null) {
            attributes.addFlashAttribute("message", "添加失败！");
        } else {
            attributes.addFlashAttribute("message", "添加成功！");
        }
        return "redirect:/admin/types";
    }

    @PostMapping("/types/{id}")
    public String editSave(@Valid Type type, BindingResult result, @PathVariable Long id, RedirectAttributes attributes) {
        Type types = typeService.getTypeByName(type.getName());
        if (types != null) {
            result.rejectValue("name", "nameError", "分类名称重复，修改/编辑失败！");
        }
        if (result.hasErrors()) {
            return "/admin/types_add";
        }
        Type newType = typeService.updateType(id, type);
        if (newType == null) {
            attributes.addFlashAttribute("message", "更新失败！");
        } else {
            attributes.addFlashAttribute("message", "更新成功！");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/remove")
    public String remove(@PathVariable Long id, RedirectAttributes attributes) {
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功！");
        return "redirect:/admin/types";
    }

}
