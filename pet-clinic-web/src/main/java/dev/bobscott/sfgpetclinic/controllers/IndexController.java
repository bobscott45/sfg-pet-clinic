package dev.bobscott.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {

    @RequestMapping({"","/", "index", "index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping("/oups")
    public RedirectView oups() {
        return new RedirectView("notimplemented");
    }

    @RequestMapping("/notimplemented")
    public String notImplemented() {
        return "notimplemented";
    }
}
