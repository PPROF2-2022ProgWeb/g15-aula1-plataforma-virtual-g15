package com.saberconectar.sc.mapper;

import com.saberconectar.sc.entity.SaleEntity;
import com.saberconectar.sc.dto.SaleDTO;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class SaleMapper {
    public SaleEntity saleDTO2Entity(SaleDTO dto){
        SaleEntity saleEntity = new SaleEntity();
        saleEntity.setProductQuantity(dto.getProductQuantity());
        saleEntity.setTotalPrice(dto.getTotalPrice());
        saleEntity.setDeleted(dto.getDeleted());
        saleEntity.setProductId(dto.getProductId());
        return saleEntity;
    }
    public SaleDTO saleEntity2DTO(SaleEntity entity){
        SaleDTO dto = new SaleDTO();
        dto.setId(entity.getId());
        dto.setProductQuantity(entity.getProductQuantity());
        dto.setTotalPrice(entity.getTotalPrice());
        dto.setDeleted(entity.getDeleted());
        dto.setProductId(entity.getProductId());
        return dto;
    }
    public SaleEntity update(SaleEntity entity, SaleDTO dto){
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setProductQuantity(dto.getProductQuantity());
        entity.setTotalPrice(dto.getTotalPrice());
        entity.setDeleted(dto.getDeleted());
        entity.setProductId(dto.getProductId());
        return entity;
    }
}
