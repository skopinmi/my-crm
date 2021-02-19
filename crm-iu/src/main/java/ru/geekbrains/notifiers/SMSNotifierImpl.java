package ru.geekbrains.notifiers;

import org.springframework.stereotype.Component;
import ru.geekbrains.models.User;
import ru.geekbrains.services.repr.UserRepr;

@Component
public class SMSNotifierImpl implements Notifier {
    @Override
    public boolean login() {
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public void notify(UserRepr userRepr, String message) {

    }
}
