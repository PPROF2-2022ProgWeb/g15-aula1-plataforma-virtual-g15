package com.saberconectar.sc.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class InvoiceTypeDTO {
    private Long id;
    private Character type;
    private Boolean deleted = Boolean.FALSE;
}
