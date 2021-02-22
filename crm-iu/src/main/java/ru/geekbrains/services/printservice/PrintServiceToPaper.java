package ru.geekbrains.services.printservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.services.dbservice.repr.Message;

public class PrintServiceToPaper implements PrintService {

    private static final Logger logger = LoggerFactory.getLogger(PrintServiceToPaper.class);

    @Override
    public void print(Message message) {
        logger.info("print to paper " + message.getText());
    }
}
