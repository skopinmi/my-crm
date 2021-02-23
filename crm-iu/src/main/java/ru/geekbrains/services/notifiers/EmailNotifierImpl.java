package ru.geekbrains.services.notifiers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.geekbrains.models.User;
import ru.geekbrains.services.dbservice.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class EmailNotifierImpl implements Notifier{

    private final UserService userService;

    @Override
    public boolean login() {
        return true;
    }

    @Override
    public boolean logout() {
        return true;
    }

    @Override
    public boolean notify(List<User> userList, String message) {
        for (User user: userList) {
            log.info(user.getName() + " notified " + message);
        }
        return true;
    }

    @Override
    public void send(List<User> userList, String message) {
        report(login(), TypeOfReport.LOGIN);
        report(notify(userList, message), TypeOfReport.NOTIFY);
        report(logout(), TypeOfReport.LOGOUT);
    }

    @Override
    public void sendAll() {
        report(login(), TypeOfReport.LOGIN);
        report(notify(userService.findAll(), "The Sale"), TypeOfReport.NOTIFY);
        report(logout(), TypeOfReport.LOGOUT);
    }

    @Override
    public void report(boolean bn, TypeOfReport type) {
        log.info(type.name() + this.getClass().getSimpleName() + " is " + bn);
    }
}
