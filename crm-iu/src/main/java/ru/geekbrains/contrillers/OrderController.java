package ru.geekbrains.contrillers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.services.OrderEntryService;
import ru.geekbrains.services.OrderService;

@Controller
public class OrderController {

    OrderService orderService;
    OrderEntryService orderEntryService;

    @Autowired
    public OrderController(OrderService orderService,
                           OrderEntryService orderEntryService) {
        this.orderService = orderService;
        this.orderEntryService = orderEntryService;
    }

    @GetMapping("/orders")
    public String ordersPage(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "orders";
    }
    @GetMapping("/order/{id}")
    public String ordersPage(Model model, @PathVariable Long id) {
        model.addAttribute("order", orderService.findById(id));
        model.addAttribute("orderEntry", orderService.findById(id).getOrderEntries());
        return "order";
    }
    @RequestMapping ("/order/{id}/delete")
    public String orderRemove(Model model, @PathVariable Long id) {
        orderService.remove(id);
        return "redirect:/orders";
    }
    @GetMapping ("/orderEntry/{id}/delete")
    public String orderEntryRemove(Model model, @PathVariable Long id) {
        String path = "/" + orderEntryService.findById(id).getOrder().getId();
        orderEntryService.remove(id);
        return "redirect:/order" + path;
    }
}
