package cn.duojunrui.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 后台管理控制器
 *
 * @className: AdminController
 * @author: Duojunrui
 * @date: 2019-04-26 22:22
 */

@Controller
@RequestMapping("/admins")
public class AdminController {

    /**
    * 获取后台管理主界面
    * @param
    * @return
    * @date 2019/4/26 22:25
    */
    public ModelAndView listUsers(Model model){
        return new ModelAndView("admins/index", "menuList", model);
    }
}
