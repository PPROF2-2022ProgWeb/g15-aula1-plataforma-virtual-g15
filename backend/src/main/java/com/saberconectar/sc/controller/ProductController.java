package com.saberconectar.sc.controller;

import com.saberconectar.sc.dto.ProductDTO;
import com.saberconectar.sc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll(){
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok().body(products);
    }
    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO product){
        ProductDTO productSaved = productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO product) {
        ProductDTO productUpdated = productService.update(id, product);
        return ResponseEntity.ok().body(productUpdated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
