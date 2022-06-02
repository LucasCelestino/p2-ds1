package com.projeto.p2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController
{
    @GetMapping("/")
    public String index(Model model)
    {
		return "index";
    }
}
