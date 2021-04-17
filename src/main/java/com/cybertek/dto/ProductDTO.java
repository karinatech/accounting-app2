package com.cybertek.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;
    private Integer qty;
    private Integer price;
    private String unit;
    private Integer lowLimitAlert;
    private Integer tax;
    private Boolean enabled;
}
