package ru.geekbrains.notifiers;

import org.springframework.stereotype.Component;
import ru.geekbrains.models.User;
import ru.geekbrains.services.repr.UserRepr;

@Component
public class SMSNotifierImpl implements Notifier {
    @Override
    public boolean login() {
        report();
        return false;
    }

    @Override
    public boolean logout() {
        report();
        return false;
    }

    @Override
    public boolean notify(UserRepr userRepr, String message) {
        return true;
    }

    @Override
    public void send(UserRepr userRepr, String message) {
        login();
        notify(userRepr, message);
        report();
        logout();
    }

    @Override
    public void report(Boolean bn) {
        System.out.println("Called notify from " + this.getClass().getSimpleName() +  " result " + bn);
    }

    @Override
    public void report() {
        System.out.println("Login/Logout " + this.getClass().getSimpleName());
    }
}
