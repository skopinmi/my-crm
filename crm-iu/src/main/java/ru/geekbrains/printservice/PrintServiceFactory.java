package ru.geekbrains.printservice;

public class PrintServiceFactory {

    enum PrintType{
        TO_PAPER,
        TO_FILE,
    }

    public PrintService getPrintService (PrintType printType) {
        PrintService printService;
        switch (printType) {
            case TO_FILE: {
                System.out.println("TO_FILE");
                printService = new PrintServiceToFile();
                break;
            }
            case TO_PAPER: {
                System.out.println("TO_PAPER");
                printService = new PrintServiceToPaper();
                break;
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
        return printService;
    }

}
