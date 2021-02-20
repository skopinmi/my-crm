package ru.geekbrains.printservice;

import ru.geekbrains.services.repr.Message;


import java.io.FileWriter;
import java.io.IOException;

public class PrintServiceToFile implements PrintService {


    private FileWriter fileWriter;

    public PrintServiceToFile(){

    }

    @Override
    public void print(Message message) {
        try (FileWriter fileWriter = new FileWriter(message.getTargetFile())) {
            fileWriter.write(message.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("print to file " + message.getText() + " to " + message.getTargetFile().getName());
    }
}
