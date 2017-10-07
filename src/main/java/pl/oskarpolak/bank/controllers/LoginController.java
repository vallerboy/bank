package pl.oskarpolak.bank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @PostMapping("/")
    public String index(@RequestParam("login") String login,
                        @RequestParam("password") String password,
                        @RequestParam("nickname") String nick,
                        Model model
                        ){
        if(login.equals("oskar") && password.equals("admin") && !nick.isEmpty()){
            model.addAttribute("nickname", nick);
            return "redirect:/dashboard";
        }
        model.addAttribute("error", "Podałeś nieprawidłowe dane!");
       return "loginTemplate";
    }

    @GetMapping("/")
    public String index(){
        return "loginTemplate";
    }
}
