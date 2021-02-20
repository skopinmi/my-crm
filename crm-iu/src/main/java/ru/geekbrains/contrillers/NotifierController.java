package ru.geekbrains.contrillers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.services.notifiers.EmailNotifierImpl;
import ru.geekbrains.services.notifiers.SMSNotifierImpl;
import ru.geekbrains.services.dbservice.StatusServiceImpl;
import ru.geekbrains.services.dbservice.UserServiceImpl;

@Controller
public class NotifierController {

    private final UserServiceImpl userServiceImpl;
    private EmailNotifierImpl emailNotifier;
    private SMSNotifierImpl SMSNotifier;

    private StatusServiceImpl statusServiceImpl;

    @Autowired
    public NotifierController(
            EmailNotifierImpl emailNotifier,
            SMSNotifierImpl SMSNotifier,
            StatusServiceImpl statusServiceImpl,
            UserServiceImpl userServiceImple) {
        this.emailNotifier = emailNotifier;
        this.SMSNotifier = SMSNotifier;
        this.statusServiceImpl = statusServiceImpl;
        this.userServiceImpl = userServiceImple;
    }

    @RequestMapping("/notify/status/{id}")
    public String notify(Model model, @PathVariable Long id) {
        emailNotifier.send(userServiceImpl.findByStatusId(id), "New Sale");
        return "redirect:/";
    }

    @RequestMapping("/notify")
    public String notifyAll(Model model) {
        emailNotifier.sendAll();
        return "redirect:/";
    }

}
