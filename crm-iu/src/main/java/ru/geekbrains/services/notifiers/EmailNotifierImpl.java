package ru.geekbrains.services.notifiers;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.geekbrains.services.dbservice.UserService;
import ru.geekbrains.services.dbservice.repr.UserRepr;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailNotifierImpl implements Notifier{

    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(SMSNotifierImpl.class);

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
            logger.info(userRepr.getName() + " notified " + message);
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
        logger.info(type.name() + this.getClass().getSimpleName() + " is " + bn);
    }
}
