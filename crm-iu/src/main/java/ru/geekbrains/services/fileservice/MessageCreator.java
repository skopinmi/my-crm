package ru.geekbrains.fileservice;

import lombok.Data;
import org.hibernate.id.UUIDGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.html.HTMLTableElement;
import ru.geekbrains.services.repr.Message;

import java.io.File;
import java.util.UUID;

//требует доработки

@Data
@Service
public class MessageCreator {

    private HTMLTableElement htmlTableElement;

    @Value("${file.storage.path}")
    private String path;

    public MessageCreator() {
    }

    public Message getMessage() {
        String name = UUID.randomUUID() + "";
        Message message = new Message();
        message.setAuthor("My");
        message.setTargetFile(new File(path + name + ".txt"));
        message.setText("My text!");
        return message;
    }
}
