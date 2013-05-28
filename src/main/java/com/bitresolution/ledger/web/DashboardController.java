package com.bitresolution.ledger.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

    @RequestMapping(value = {"", "/", "/dashboard"})
    public ModelAndView showHomepage() {
        return new ModelAndView("dashboard");
    }
}

