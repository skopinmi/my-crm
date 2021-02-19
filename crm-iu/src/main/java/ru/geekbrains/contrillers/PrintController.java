package ru.geekbrains.contrillers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.printservice.PrintServiceFactory;
import ru.geekbrains.fileservice.MessageCreator;


@Controller
public class PrintController {

    PrintServiceFactory printServiceFactory;
    MessageCreator messageCreator;


    @Autowired
    public PrintController(PrintServiceFactory printServiceFactory,
                           MessageCreator messageCreator) {
        this.printServiceFactory = printServiceFactory;
        this.messageCreator = messageCreator;
    }

    @RequestMapping("/print")
    public String printPageFile(Model model) {
        model.addAttribute("activePage", "None");
        printServiceFactory.getPrintService(PrintServiceFactory.PrintType.TO_FILE)
                .print(messageCreator.getMessage());
        return "redirect:/";
    }

    @RequestMapping("/printPR")
    public String printPagePrinter(Model model) {
        model.addAttribute("activePage", "None");
        printServiceFactory.getPrintService(PrintServiceFactory.PrintType.TO_PAPER)
                .print(messageCreator.getMessage());
        return "redirect:/";
    }
}
