package ru.geekbrains.services.printservice;

import org.springframework.stereotype.Service;

@Service
public class PrintServiceFactory {

    public enum PrintType{
        TO_PAPER,
        TO_FILE,
    }

    private PrintService printServiceToFile;
    private PrintService printServiceToPaper;

    public PrintService getPrintService (PrintType printType) {
        PrintService printService;
        switch (printType) {
            case TO_FILE: {
                System.out.println("TO_FILE");
                if (printServiceToFile == null) {
                    printServiceToFile = new PrintServiceToFile();
                }
                return printServiceToFile;
            }
            case TO_PAPER: {
                if (printServiceToPaper == null) {
                    printServiceToPaper = new PrintServiceToPaper();
                }
                return printServiceToPaper;
            }
//            case TO_ZIP_FILE: {
//                System.out.println("TO_ZIP_FILE");
//                printService = new PrintServiceToPaper();
//                break;
//            }
            default: {
                throw new IllegalArgumentException("unknown PrintType " + this.getClass().getSimpleName());
            }
        }
    }
}
