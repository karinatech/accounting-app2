package com.cybertek.service;

import com.cybertek.dto.ProductDTO;
import com.cybertek.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> listAllProducts();
    ProductDTO findProductByProductId(Integer productId);
    void delete(ProductDTO productDTO);
    Product save(ProductDTO productDTO);
    void update(ProductDTO productDTO);


}
