package dgtic.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OurController {

    @RequestMapping(value = "nosotros", method = RequestMethod.GET)
    public String nosotros(Model model) {
        model.addAttribute("modelo");
        return "nosotros/nosotros";
    }

    @GetMapping("Inicio")
    public String Inicio(Model model){
        model.addAttribute("start");
        return "index";
    }

    @GetMapping("Coberturas2")
    public String Coberturas(Model model){
        model.addAttribute("cobe");
        return "coberturas/coberturas";
    }



}


