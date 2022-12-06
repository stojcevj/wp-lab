package mk.finki.ukim.wp.lab.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "balloon_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String name;

    private String surname;

    private String password;

    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "user")
    private List<ShoppingCart> carts;

    public User(String username, String name, String surname, String password, LocalDate dateOfBirth) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.carts = new ArrayList<>();
    }

    public User(){
    }
}
