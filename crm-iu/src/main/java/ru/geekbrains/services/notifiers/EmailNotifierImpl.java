package ru.geekbrains.services.notifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.services.dbservice.UserService;
import ru.geekbrains.services.dbservice.repr.UserRepr;
import java.util.List;

@Service
public class EmailNotifierImpl implements Notifier{

    UserService userService;

    @Autowired
    public EmailNotifierImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean login() {
        return true;
    }

    @Override
    public boolean logout() {
        return true;
    }

    @Override
    public boolean notify(List<UserRepr> userReprList, String message) {
        for (UserRepr userRepr: userReprList) {
            System.out.println(userRepr.getName() + " notified " + message);
        }
        return true;
    }

    @Override
    public void send(List<UserRepr> userReprList, String message) {
        report(login(), TypeOfReport.LOGIN);
        report(notify(userReprList, message), TypeOfReport.NOTIFY);
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
        System.out.println(type.name() + this.getClass().getSimpleName() + " is " + bn);
    }
}
