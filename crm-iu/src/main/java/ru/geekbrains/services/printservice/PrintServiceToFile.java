package ru.geekbrains.services.printservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.services.dbservice.repr.Message;


import java.io.FileWriter;
import java.io.IOException;

public class PrintServiceToFile implements PrintService {


    private FileWriter fileWriter;

    private static final Logger logger = LoggerFactory.getLogger(PrintServiceToFile.class);

    @Override
    public void print(Message message) {
        try (FileWriter fileWriter = new FileWriter(message.getTargetFile())) {
            fileWriter.write(message.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("print to file " + message.getText() + " to " + message.getTargetFile().getName());
    }
}
