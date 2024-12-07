package org.example.controller;

import com.neptun.neptun_web.model.Hallgato;
import com.neptun.neptun_web.service.NeptunRendszer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HallgatoController {

    private final NeptunRendszer neptunRendszer;

    public HallgatoController() {
        this.neptunRendszer = new NeptunRendszer();
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("hallgatok", neptunRendszer.getHallgatok());
        return "index";
    }

    @PostMapping("/ujHallgato")
    public String ujHallgato(@RequestParam String nev, @RequestParam String neptunKod) {
        neptunRendszer.ujHallgato(neptunKod, nev);
        return "redirect:/";
    }

    @GetMapping("/keresHallgato")
    public String keresHallgato(@RequestParam String neptunKod, Model model) {
        Hallgato hallgato = neptunRendszer.keresHallgato(neptunKod);
        model.addAttribute("hallgato", hallgato);
        return "kereses";
    }
}
