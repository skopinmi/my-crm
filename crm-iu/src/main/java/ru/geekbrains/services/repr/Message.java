package ru.geekbrains.services.repr;

import lombok.Data;

import java.io.File;

@Data

public class Message {

    private String author;

    private String source;

    private File targetFile;

    private String text;


}
