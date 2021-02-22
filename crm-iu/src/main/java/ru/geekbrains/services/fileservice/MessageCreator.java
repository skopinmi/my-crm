package ru.geekbrains.services.fileservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.geekbrains.services.dbservice.repr.Message;

import java.io.File;
import java.util.UUID;

@Service

public class MessageCreator {

    @Value("${file.storage.path}")
    private String path;

    public Message getMessage() {
        String name = UUID.randomUUID() + "";
        Message message = new Message();
        message.setAuthor("My");
        message.setTargetFile(new File(path + name + ".txt"));
        message.setText("My text!");
        return message;
    }
}
