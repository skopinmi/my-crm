package ru.geekbrains.contrillers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.services.dbservice.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("activePage", "None");
        return "index";
    }

    @GetMapping("/users")
    public String adminUsersPage(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/user/{id}/delete")
    public String removeUser(@PathVariable Long id) {
        userService.remove(id);
        return "redirect:/users";
    }
}
