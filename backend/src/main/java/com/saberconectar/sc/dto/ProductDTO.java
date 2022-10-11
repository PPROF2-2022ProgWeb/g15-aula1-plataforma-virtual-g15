package com.saberconectar.sc.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private Boolean deleted = Boolean.FALSE;
}

