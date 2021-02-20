package ru.geekbrains.services.dbservice.repr;

import lombok.Data;
import ru.geekbrains.models.Role;
import ru.geekbrains.models.Status;
import ru.geekbrains.models.User;

import java.util.Set;

@Data
public class UserRepr {

    private Long id;

    private String name;

    private String phone;

    private String email;

    private String description;

    private Status status;

    private Set<Role> roles;

    public UserRepr() {
    }

    public UserRepr(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.status = user.getStatus();
        this.status = user.getStatus();
        this.roles = user.getRoles();
    }
}
