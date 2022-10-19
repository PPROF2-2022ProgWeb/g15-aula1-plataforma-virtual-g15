package com.saberconectar.sc.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
public class InvoiceDTO {
    private Long id;
    private LocalDate date;
    private Boolean deleted;
    private Long invoiceTypeId;
    private Long saleId;
    private Long userId;
}
