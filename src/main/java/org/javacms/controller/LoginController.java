package org.javacms.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.javacms.beans.User;
import org.javacms.service.LoginServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"userId", "userName"})
public class LoginController {
    @Autowired
    private LoginServiceInterface loginService;
    @RequestMapping(value ="/admin/login", method=RequestMethod.POST)
    public String login(User user, Model model) {
        
        //ModelAndView mv = new ModelAndView();
        String md5Str = DigestUtils.md5Hex(user.getPassword());
        //String md5Str = DigestUtils.md5Hex("admin");
        
        user = loginService.login(user.getUsername(), DigestUtils.md5Hex(user.getPassword()));
        if (user != null) {
            model.addAttribute("userId", user.getUserId());
            model.addAttribute("userName", user.getUsername());
        }
        return "/admin/main";
    }
}
