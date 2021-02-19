package ru.geekbrains.notifiers;

import ru.geekbrains.services.repr.UserRepr;

public interface Notifier {

    boolean login ();

    boolean logout();

    boolean notify(UserRepr userRepr, String message);

    void report(Boolean bn);

    void report();

    void send(UserRepr userRepr, String message);
}
