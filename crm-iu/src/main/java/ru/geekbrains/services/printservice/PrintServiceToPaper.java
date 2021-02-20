package ru.geekbrains.printservice;

import ru.geekbrains.services.repr.Message;

public class PrintServiceToPaper implements PrintService {

    public PrintServiceToPaper() {
    }

    @Override
    public void print(Message message) {
        System.out.println("print to paper " + message.getText());
    }
}
