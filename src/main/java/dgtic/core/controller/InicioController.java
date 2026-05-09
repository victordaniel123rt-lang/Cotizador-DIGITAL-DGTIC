package dgtic.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InicioController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String inicio(Model model) {
        model.addAttribute("contenido");
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }



    @GetMapping("principal")
    public String principal(Model model) {
        model.addAttribute("contenido");
        return "principal/principal";

    }
}
