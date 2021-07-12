package com.example.springsecurityjwtapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User extends BaseEntity {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

//    @JoinTable(name = "user_role",
//            joinColumns = {@JoinColumn(name = "user_id",
//                    referencedColumnName = "id")},
//            inverseJoinColumns ={@JoinColumn(name = "role_id",referencedColumnName = "id")}
//    )
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

}
