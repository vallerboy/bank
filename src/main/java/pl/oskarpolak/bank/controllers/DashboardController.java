package pl.oskarpolak.bank.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.oskarpolak.bank.models.RequestForm;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("formRequest", new RequestForm());
        return "dashboardTemplate";
    }

    @PostMapping("/dashboard")
    public String dashboard(@ModelAttribute("formRequest") RequestForm form, Model model){
        model.addAttribute("infoCredit", canGetCredit(form));
        return "dashboardTemplate";
    }

    private boolean canGetCredit(RequestForm form){
        return (form.getMonthCash() - form.getMinusCash()) * 0.7 > form.getCreditCash()/form.getCreditTime();
    }

}
