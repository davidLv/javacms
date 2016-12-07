package org.javacms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"/admin/"})
    public String loginAction(Model model) {
        model.addAttribute("greeting", "Hello spring mvc");
        return "/admin/login";
    }
    
    @RequestMapping("/admin/index")
    public String indexAction(HttpSession session) {
        return "/admin/index_frameset";
    }
    
    @RequestMapping("/admin/top")
    public String topAction() {
        return "/admin/top";
    }
    
    @RequestMapping("/admin/content")
    public String contentAction() {
        return "/admin/index";
    }
    
    @RequestMapping("/admin/left")
    public String leftAction() {
        return "/admin/left";
    }
    
    @RequestMapping("/admin/right")
    public String rightAction() {
        return "/admin/right";
    }
}
