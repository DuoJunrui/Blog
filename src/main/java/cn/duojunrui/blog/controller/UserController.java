package cn.duojunrui.blog.controller;

import cn.duojunrui.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * TODO
 *
 * @className: UserController
 * @author: Duojunrui
 * @date: 2019-04-26 22:26
 */

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public ModelAndView list(Model model){
        model.addAttribute("userList", userRepository);
        return null;
    }

}
