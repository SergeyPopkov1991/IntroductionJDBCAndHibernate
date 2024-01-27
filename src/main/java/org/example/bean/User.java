package org.example.bean;


import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    long id;
    String name;
    String lastName;
    byte age;


}
