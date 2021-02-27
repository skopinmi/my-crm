package ru.geekbrains.services.printservice;

import lombok.extern.log4j.Log4j2;
import ru.geekbrains.services.dbservice.repr.Message;


import java.io.FileWriter;
import java.io.IOException;

@Log4j2
public class PrintServiceToFile implements PrintService {

    @Override
    public void print(Message message) {
        try (FileWriter fileWriter = new FileWriter(message.getTargetFile())) {
            fileWriter.write(message.getText());
        } catch (IOException e) {
            log.info(e.getStackTrace());
        }
        log.info("print to file " + message.getText() + " to " + message.getTargetFile().getName());
    }
}
