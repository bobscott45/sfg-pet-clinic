package dev.bobscott.sfgpetclinic.controllers;

import dev.bobscott.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "index"})
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping("find")
    public RedirectView findOwners() {
        return new RedirectView("/notimplemented");
    }
}
