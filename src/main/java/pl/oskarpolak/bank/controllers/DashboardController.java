package pl.oskarpolak.bank.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.oskarpolak.bank.models.RequestForm;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("formRequest", new RequestForm());
        return "dashboardTemplate";
    }

}
