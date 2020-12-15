package main;


import main.model.Plan;
import main.model.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class DefaultController {
    @Autowired
    PlanRepository repository;
    @RequestMapping("/")
    public String getNumber(Model model){
        return "index";
    }
}
