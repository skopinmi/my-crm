package ru.geekbrains.notifiers;

import ru.geekbrains.models.User;
import ru.geekbrains.services.repr.UserRepr;

public interface Notifier {
    boolean login ();
    boolean logout();
    void notify(UserRepr userRepr, String message);
}
