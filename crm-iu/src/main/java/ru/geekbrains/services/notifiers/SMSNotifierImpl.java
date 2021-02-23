package ru.geekbrains.services.notifiers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.geekbrains.services.dbservice.UserServiceImpl;
import ru.geekbrains.services.dbservice.repr.UserRepr;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class SMSNotifierImpl implements Notifier {

    private final UserServiceImpl userService;

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
            log.info(userRepr.getName() + " notified " + message);
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
        log.info(type.name() + this.getClass().getSimpleName() + " is " + bn);
    }
}
