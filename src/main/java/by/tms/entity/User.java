package by.tms.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "calc_users",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private String username;

    private String email;

    private String password;

}
