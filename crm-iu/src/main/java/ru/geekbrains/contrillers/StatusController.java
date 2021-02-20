package ru.geekbrains.contrillers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.repositories.StatusRepository;
import ru.geekbrains.services.dbservice.StatusServiceImpl;


@Controller
public class StatusController {

    StatusServiceImpl statusServiceImpl;

    @Autowired
    public StatusController (StatusServiceImpl statusServiceImpl) {
        this.statusServiceImpl = statusServiceImpl;
    }

    @RequestMapping("/statuses")
    public String statusPage(Model model) {
        model.addAttribute("statuses", statusServiceImpl.findAll());
        return "statuses";
    }

//    @RequestMapping("/status/{id}/delete")
//    public String removeStatus( @PathVariable Long id) {
//        statusServiceImpl.remove(id);
//        return "redirect:/statuses";
//    }
}
