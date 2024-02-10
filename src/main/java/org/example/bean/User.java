package org.example.bean;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Table(name = "user")
@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column
    String name;
    @Column
    String lastName;
    @Column
    byte age;

    public User(String name, String lastName, byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}
