package ru.geekbrains.contrillers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.repositories.StatusRepository;



@Controller
public class StatusController {
    StatusRepository statusRepository;

    @Autowired
    public StatusController (StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @RequestMapping("/statuses")
    public String statusPage(Model model) {
        model.addAttribute("activePage", "None");
        model.addAttribute("statuses", statusRepository.findAll());
        return "statuses";
    }
}
