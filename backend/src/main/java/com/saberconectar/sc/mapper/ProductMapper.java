package com.saberconectar.sc.mapper;

import com.saberconectar.sc.dto.ProductDTO;
import com.saberconectar.sc.entity.ProductEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class ProductMapper {
    public ProductEntity productDTO2Entity(ProductDTO dto){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(dto.getName());
        productEntity.setPrice(dto.getPrice());
        productEntity.setDeleted(dto.getDeleted());
        return productEntity;
    }
    public ProductDTO productEntity2DTO(ProductEntity entity){
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDeleted(entity.getDeleted());
        return dto;
    }
    public List<ProductDTO> productEntityList2DTOList(List<ProductEntity> entities){
        List<ProductDTO> dtos = new ArrayList<>();
        for (ProductEntity entity: entities){
            dtos.add(productEntity2DTO(entity));
        }
        return dtos;
    }
    public ProductEntity update(ProductEntity entity, ProductDTO dto){
        productEntity.setName(dto.getName());
        productEntity.setPrice(dto.getPrice());
        productEntity.setDeleted(dto.getDeleted());
        return entity;
    }
}
