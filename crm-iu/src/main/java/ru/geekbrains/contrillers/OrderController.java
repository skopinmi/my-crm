package ru.geekbrains.contrillers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.services.dbservice.OrderEntryServiceImpl;
import ru.geekbrains.services.dbservice.OrderServiceImpl;

@Controller
public class OrderController {

    OrderServiceImpl orderServiceImpl;
    OrderEntryServiceImpl orderEntryServiceImpl;

    @Autowired
    public OrderController(OrderServiceImpl orderServiceImpl,
                           OrderEntryServiceImpl orderEntryServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
        this.orderEntryServiceImpl = orderEntryServiceImpl;
    }

    @GetMapping("/orders")
    public String ordersPage(Model model) {
        model.addAttribute("orders", orderServiceImpl.findAll());
        return "orders";
    }
    @GetMapping("/order/{id}")
    public String ordersPage(Model model, @PathVariable Long id) {
        model.addAttribute("order", orderServiceImpl.findById(id));
        model.addAttribute("orderEntry", orderServiceImpl.findById(id).getOrderEntries());
        return "order";
    }
    @RequestMapping ("/order/{id}/delete")
    public String orderRemove(Model model, @PathVariable Long id) {
        orderServiceImpl.remove(id);
        return "redirect:/orders";
    }
    @GetMapping ("/orderEntry/{id}/delete")
    public String orderEntryRemove(Model model, @PathVariable Long id) {
        String path = "/" + orderEntryServiceImpl.findById(id).getOrder().getId();
        orderEntryServiceImpl.remove(id);
        return "redirect:/order" + path;
    }
}
