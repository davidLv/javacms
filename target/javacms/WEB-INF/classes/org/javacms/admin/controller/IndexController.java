package org.javacms.admin.controller;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("greeting", "Hello spring mvc");
        return "index";
    }
}
