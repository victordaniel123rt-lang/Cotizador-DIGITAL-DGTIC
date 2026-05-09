package dgtic.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CoberturaController {
    @RequestMapping(value = "coberturas", method = RequestMethod.GET)
    public String nosotros(Model model) {
        model.addAttribute("proteccion");
        return "coberturas/coberturas";
    }

    @GetMapping("Inicio2")
    public String Inicio(Model model){
        model.addAttribute("start");
        return "index";
    }

}
