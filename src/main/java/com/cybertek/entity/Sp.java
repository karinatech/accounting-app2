package com.cybertek.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sp extends BaseEntity{
    private String companyName;
    @OneToOne(mappedBy = "sp",fetch = FetchType.LAZY)
    private Invoice invoice;
    private String phone;
    private String email;
    private String type;
    private String zipCode;
    private String address;
    private String state;
    private Boolean enabled;
    @OneToOne(fetch = FetchType.LAZY)
    private Company company;

}
