package ru.geekbrains.contrillers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.notifiers.EmailNotifierImpl;
import ru.geekbrains.notifiers.SMSNotifierImpl;
import ru.geekbrains.repositories.StatusRepository;
import ru.geekbrains.services.StatusService;
import ru.geekbrains.services.UserService;
import ru.geekbrains.services.UserServiceImpl;

@Controller
public class NotifierController {

    private final UserServiceImpl userServiceImpl;
    private EmailNotifierImpl emailNotifier;
    private SMSNotifierImpl SMSNotifier;

    private StatusService statusService;

    @Autowired
    public NotifierController(
                              EmailNotifierImpl emailNotifier,
                              SMSNotifierImpl SMSNotifier,
                              StatusService statusService,
                              UserServiceImpl userServiceImple) {
        this.emailNotifier = emailNotifier;
        this.SMSNotifier = SMSNotifier;
        this.statusService = statusService;
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
