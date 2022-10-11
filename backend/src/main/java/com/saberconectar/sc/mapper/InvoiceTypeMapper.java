package com.saberconectar.sc.mapper;

import com.saberconectar.sc.dto.InvoiceTypeDTO;
import com.saberconectar.sc.entity.InvoiceTypeEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class InvoiceTypeMapper {
    public InvoiceTypeEntity invoiceTypeDTO2Entity(InvoiceTypeDTO dto){
        InvoiceTypeEntity invoiceTypeEntity = new InvoiceTypeEntity();
        invoiceTypeEntity.setType(dto.getType());
        invoiceTypeEntity.setDeleted(dto.getDeleted());
        return invoiceTypeEntity;
    }
    public InvoiceTypeDTO invoiceTypeEntity2DTO(InvoiceTypeEntity entity){
        InvoiceTypeDTO dto = new InvoiceTypeDTO();
        dto.setId(entity.getId());
        dto.setType(entity.getType());
        dto.setDeleted(entity.getDeleted());
        return dto;
    }
    public List<InvoiceTypeDTO> invoiceTypeEntityList2DTOList(List<InvoiceTypeEntity> entities){
        List<InvoiceTypeDTO> dtos = new ArrayList<>();
        for (InvoiceTypeEntity entity: entities){
            dtos.add(invoiceTypeEntity2DTO(entity));
        }
        return dtos;
    }
    public InvoiceTypeEntity update(InvoiceTypeEntity entity, InvoiceTypeDTO dto){
        entity.setType(dto.getType());
        entity.setDeleted(dto.getDeleted());
        return entity;
    }
}
