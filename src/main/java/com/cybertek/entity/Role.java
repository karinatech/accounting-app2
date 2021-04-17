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
public class Role extends BaseEntity{
    private String name;
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "roles")
   private List <User> users;

}
