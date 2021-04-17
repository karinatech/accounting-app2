package com.cybertek.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userz")
public class User extends BaseEntity{

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Boolean enabled;
    private String phone;

    @ManyToMany
    @JoinTable(name = "userRole",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List <Role> roles;

    @ManyToOne
    private Company company;



}
