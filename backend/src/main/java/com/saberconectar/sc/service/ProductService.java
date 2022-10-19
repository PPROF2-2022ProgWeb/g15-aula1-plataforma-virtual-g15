package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.ProductDTO;
import java.util.List;
public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO save(ProductDTO product);
    ProductDTO update(Long id, ProductDTO product);
    void delete (Long id);
    void isCorrect(Long id);
}
