package cn.duojunrui.blog.web.admin;

import cn.duojunrui.blog.entity.Tag;
import cn.duojunrui.blog.entity.Type;
import cn.duojunrui.blog.service.TagService;
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
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String tags(@PageableDefault(size = 3, sort = {"id"}, direction = Sort.Direction.DESC)
                                Pageable pageable, Model model) {
        model.addAttribute("page", tagService.listTag(pageable));
        return "/admin/tags";
    }

    @GetMapping("/tags/add")
    public String add(Model model) {
        model.addAttribute("tag", new Type());
        return "/admin/tags_add";
    }

    @GetMapping("/tags/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("tag", tagService.getTag(id));
        return "/admin/tags_add";
    }

    @PostMapping("/tags")
    public String save(@Valid Tag tag, BindingResult result, RedirectAttributes attributes) {
        Tag tags = tagService.getTagByName(tag.getName());
        if (tags != null) {
            result.rejectValue("name", "nameError", "标签名称重复，添加失败！");
        }
        if (result.hasErrors()) {
            return "/admin/tags_add";
        }
        Tag newTag = tagService.saveTag(tag);
        if (newTag == null) {
            attributes.addFlashAttribute("message", "添加失败！");
        } else {
            attributes.addFlashAttribute("message", "添加成功！");
        }
        return "redirect:/admin/tags";
    }

    @PostMapping("/tags/{id}")
    public String editSave(@Valid Tag tag, BindingResult result, @PathVariable Long id, RedirectAttributes attributes) {
        Tag tags = tagService.getTagByName(tag.getName());
        if (tags != null) {
            result.rejectValue("name", "nameError", "标签名称重复，修改/编辑失败！");
        }
        if (result.hasErrors()) {
            return "/admin/tags_add";
        }
        Tag newTag = tagService.updateTag(id, tag);
        if (newTag == null) {
            attributes.addFlashAttribute("message", "更新失败！");
        } else {
            attributes.addFlashAttribute("message", "更新成功！");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/remove")
    public String remove(@PathVariable Long id, RedirectAttributes attributes) {
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message","删除成功！");
        return "redirect:/admin/tags";
    }

}
