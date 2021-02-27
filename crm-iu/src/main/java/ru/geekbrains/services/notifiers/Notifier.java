package ru.geekbrains.services.notifiers;

import ru.geekbrains.models.User;

import java.util.List;

public interface Notifier {

    enum TypeOfReport{
        LOGIN,
        LOGOUT,
        NOTIFY
    }

    boolean login ();

    boolean logout();

    boolean notify(List<User> userList, String message);

    void report(boolean bn, TypeOfReport type);

    void sendAll();

    void send(List<User> userList, String message);
}
