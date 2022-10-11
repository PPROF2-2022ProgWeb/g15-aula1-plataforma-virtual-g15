package com.saberconectar.sc.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SaleDTO {
    private Long id;
    private Integer productQuantity;
    private Double totalPrice;
    private Boolean deleted = Boolean.FALSE;
    private Long productId;
}
