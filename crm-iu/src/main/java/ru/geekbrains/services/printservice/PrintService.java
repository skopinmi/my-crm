package ru.geekbrains.services.printservice;

import ru.geekbrains.services.dbservice.repr.Message;

public interface PrintService {

    void print(Message message);
}
