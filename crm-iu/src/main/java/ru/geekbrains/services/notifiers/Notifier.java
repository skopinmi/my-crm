package ru.geekbrains.services.notifiers;

import ru.geekbrains.services.dbservice.repr.UserRepr;

import java.util.List;

public interface Notifier {

    enum TypeOfReport{
        LOGIN,
        LOGOUT,
        NOTIFY
    }

    boolean login ();

    boolean logout();

    boolean notify(List<UserRepr> userReprList, String message);

    void report(boolean bn, TypeOfReport type);

    void sendAll();

    void send(List<UserRepr> userReprList, String message);
}
