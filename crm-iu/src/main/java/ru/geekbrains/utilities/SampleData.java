package ru.geekbrains.utilities;

import org.springframework.stereotype.Component;
import ru.geekbrains.models.*;
import ru.geekbrains.repositories.*;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//создает заполняет базу на настоящий момент с 1 клиентом
//начинал с малого, чтобы не запутаться, когда дошел до половины дела...
//


@Component
public class SampleData {

    RoleRepository roleRepository;
    StatusRepository statusRepository;
    UserRepository userRepository;
    OrderRepository orderRepository;
    ServiceRepository serviceRepository;
    OrderEntryRepository orderEntryRepository;

    public SampleData(RoleRepository roleRepository,
                      StatusRepository statusRepository,
                      UserRepository userRepository,
                      OrderRepository orderRepository,
                      ServiceRepository serviceRepository,
                      OrderEntryRepository orderEntryRepository) {
        this.roleRepository = roleRepository;
        this.statusRepository = statusRepository;
        this.userRepository = userRepository;
        this.orderEntryRepository = orderEntryRepository;
        this.orderRepository = orderRepository;
        this.serviceRepository = serviceRepository;
    }

    @PostConstruct
    public void init() {

        //создание пользователей со статусом и ролью

        Status status = new Status("VIP");
        Status status1 = new Status("Gold");
        Status status2 = new Status("default");


        User user = new User("misha", "12345678", "qwer@mail.com");
        User user1 = new User("masha", "87654321", "rewq@mail.com");
        User user2 = new User("oleg", "12348765", "qwre@mail.com");
        User user3 = new User("sasha", "43215678", "erwq@mail.com");

        user.setStatus(status);
        user1.setStatus(status1);
        user2.setStatus(status1);
        user3.setStatus(status2);


        Role role = new Role("ADMIN");
        List<User> admin = new ArrayList<>();
        admin.add(user);
        role.setUsers(admin);
        Role role1 = new Role("MANAGER");
        List<User> manager = new ArrayList<>();
        manager.add(user1);
        role1.setUsers(manager);
        Role role2 = new Role("USER");
        List<User> users = new ArrayList<>();
        users.add(user2);
        users.add(user3);
        role2.setUsers(users);

// создание заказов

        Service service = new Service("foot massage", "", new BigDecimal(1000));
        Service service1 = new Service("spine massage", "", new BigDecimal(1500));
        Service service2 = new Service("hand massage", "", new BigDecimal(1000));
        Service service3 = new Service("face massage", "", new BigDecimal(1250));

        Order order = new Order();
        OrderEntry orderEntry = new OrderEntry(service, 10);
        orderEntry.setTotalPrice(orderEntry.getBasePrice().multiply(new BigDecimal(orderEntry.getQuantity())));
        OrderEntry orderEntry1 = new OrderEntry(service1, 10);
        orderEntry1.setTotalPrice(orderEntry1.getBasePrice().multiply(new BigDecimal(orderEntry1.getQuantity())));

        orderEntry.setOrder(order);
        orderEntry1.setOrder(order);

        Order order1 = new Order();
        OrderEntry orderEntry2 = new OrderEntry(service2, 5);
        orderEntry2.setTotalPrice(orderEntry2.getBasePrice().multiply(new BigDecimal(orderEntry2.getQuantity())));
        OrderEntry orderEntry3 = new OrderEntry(service3, 5);
        orderEntry3.setTotalPrice(orderEntry3.getBasePrice().multiply(new BigDecimal(orderEntry3.getQuantity())));

        orderEntry2.setOrder(order1);
        orderEntry3.setOrder(order1);


        Order order2 = new Order();
        OrderEntry orderEntry4 = new OrderEntry(service, 3);
        orderEntry4.setTotalPrice(orderEntry4.getBasePrice().multiply(new BigDecimal(orderEntry4.getQuantity())));
        OrderEntry orderEntry5 = new OrderEntry(service3, 15);
        orderEntry5.setTotalPrice(orderEntry5.getBasePrice().multiply(new BigDecimal(orderEntry5.getQuantity())));

        orderEntry4.setOrder(order2);
        orderEntry5.setOrder(order2);

        order.setUser(user2);
        order1.setUser(user3);
        order2.setUser(user3);

        //  сохранение в базу

        statusRepository.save(status);
        statusRepository.save(status1);
        statusRepository.save(status2);

        userRepository.save(user);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        roleRepository.save(role);
        roleRepository.save(role1);
        roleRepository.save(role2);

        serviceRepository.save(service);
        serviceRepository.save(service1);
        serviceRepository.save(service2);
        serviceRepository.save(service3);

        orderRepository.save(order);
        orderRepository.save(order1);
        orderRepository.save(order2);

        orderEntryRepository.save(orderEntry);
        orderEntryRepository.save(orderEntry1);
        orderEntryRepository.save(orderEntry2);
        orderEntryRepository.save(orderEntry3);
        orderEntryRepository.save(orderEntry4);
        orderEntryRepository.save(orderEntry5);
    }
}