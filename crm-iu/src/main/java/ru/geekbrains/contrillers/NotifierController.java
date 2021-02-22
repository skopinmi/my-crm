package ru.geekbrains.contrillers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.services.dbservice.UserServiceImpl;
import ru.geekbrains.services.notifiers.EmailNotifierImpl;
import ru.geekbrains.services.notifiers.SMSNotifierImpl;

@Controller
@RequiredArgsConstructor
public class NotifierController {

    private final UserServiceImpl userServiceImpl;
    private final EmailNotifierImpl emailNotifier;
    private final SMSNotifierImpl smsNotifier;

    @GetMapping("/notify/status/{id}")
    public String notify(Model model, @PathVariable Long id) {
        emailNotifier.send(userServiceImpl.findByStatusId(id), "New Sale");
        smsNotifier.send(userServiceImpl.findByStatusId(id), "New Sale");
        return "redirect:/";
    }

    @GetMapping("/notify")
    public String notifyAll(Model model) {
        emailNotifier.sendAll();
        smsNotifier.sendAll();
        return "redirect:/";
    }
}
