package ru.geekbrains.services.printservice;

import ru.geekbrains.services.dbservice.repr.Message;

public class PrintServiceToPaper implements PrintService {

    public PrintServiceToPaper() {
    }

    @Override
    public void print(Message message) {
        System.out.println("print to paper " + message.getText());
    }
}
