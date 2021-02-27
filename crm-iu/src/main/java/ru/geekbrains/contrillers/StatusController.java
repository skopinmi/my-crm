package ru.geekbrains.contrillers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.geekbrains.services.dbservice.StatusServiceImpl;


@Controller
@RequiredArgsConstructor
public class StatusController {

    private final StatusServiceImpl statusServiceImpl;

    @GetMapping("/statuses")
    public String statusPage(Model model) {
        model.addAttribute("statuses", statusServiceImpl.findAll());
        return "statuses";
    }

//    @GetMapping("/status/{id}/delete")
//    public String removeStatus( @PathVariable Long id) {
//        statusServiceImpl.remove(id);
//        return "redirect:/statuses";
//    }
}
