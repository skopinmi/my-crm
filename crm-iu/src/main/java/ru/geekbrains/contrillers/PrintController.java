package ru.geekbrains.contrillers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.services.printservice.PrintServiceFactory;
import ru.geekbrains.services.fileservice.MessageCreator;


@Controller
@RequiredArgsConstructor
public class PrintController {

    private final PrintServiceFactory printServiceFactory;
    private final MessageCreator messageCreator;

    @GetMapping("/print")
    public String printPageFile() {
        printServiceFactory.getPrintService(PrintServiceFactory.PrintType.TO_FILE)
                .print(messageCreator.getMessage());
        return "redirect:/";
    }

    @GetMapping("/printPR")
    public String printPagePrinter() {
        printServiceFactory.getPrintService(PrintServiceFactory.PrintType.TO_PAPER)
                .print(messageCreator.getMessage());
        return "redirect:/";
    }
}
