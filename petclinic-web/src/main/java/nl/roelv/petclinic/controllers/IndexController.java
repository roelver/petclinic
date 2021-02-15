package nl.roelv.petclinic.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController implements ErrorController {

    @RequestMapping({"","/","/index","/index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping("/error")
    public String myerror() {
        return "notimplemented";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
