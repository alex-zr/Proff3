package ua.kiev.prog.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false, unique = true)
    private String login;
    private String password;

    public User() {

    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
