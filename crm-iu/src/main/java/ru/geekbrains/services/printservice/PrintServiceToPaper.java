package ru.geekbrains.services.printservice;

import lombok.extern.log4j.Log4j2;
import ru.geekbrains.services.dbservice.repr.Message;

@Log4j2
public class PrintServiceToPaper implements PrintService {

    @Override
    public void print(Message message) {
        log.info("print to paper " + message.getText());
    }
}
