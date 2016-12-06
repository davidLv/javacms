package org.javacms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"/admin/", "/admin/index"})
    public String hello(Model model) {
        model.addAttribute("greeting", "Hello spring mvc");
        return "/admin/index";
    }
}
