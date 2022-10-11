package com.saberconectar.sc.service.impl;

import com.saberconectar.sc.dto.ProductDTO;
import com.saberconectar.sc.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> entities = productRepository.findAll();
        List<ProductDTO> dtos = productMapper.productEntityList2DTOList(entities);
        return dtos;
    }
    public ProductDTO save(ProductDTO product) {
        ProductEntity entity = productMapper.productDTO2Entity(type);
        ProductEntity entitySaved = productRepository.save(entity);
        ProductDTO result = productMapper.productEntity2DTO(entitySaved);
        return result;
    }
    public ProductDTO update(Long id, ProductDTO product) {
        isCorrect(id);
        ProductEntity entityId = productRepository.getReferenceById(id);
        ProductEntity entity = productMapper.update(entityId,product);
        ProductEntity entityUpdated = productRepository.save(entity);
        ProductDTO result = productMapper.productEntity2DTO(entityUpdated);
        return result;
    }
    public void delete(Long id) {
        isCorrect(id);
        this.productRepository.deleteById(id);
    }
    public void isCorrect(Long id) {
        if(!productRepository.existsById(id)){
            throw new ParamNotFound("Invalid id");
        }
    }
}
