package com.cybertek.implementations;

import com.cybertek.cnverters.MapperUtil;
import com.cybertek.dto.ProductDTO;
import com.cybertek.entity.Product;
import com.cybertek.repo.ProductRepo;
import com.cybertek.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepo productRepo;
    private MapperUtil mapperUtil;

    public ProductServiceImpl(ProductRepo productRepo, MapperUtil mapperUtil) {
        this.productRepo = productRepo;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<ProductDTO> listAllProducts() {
        List<Product>products=productRepo.findAll();
        return products.stream().map(obj->{return mapperUtil.convert(obj,new ProductDTO());})
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findProductByProductId(Integer productId) {
        Optional<Product> product = productRepo.findById(productId);
        if (product.get().isDeleted() == false) {
            return mapperUtil.convert(product.get(), new ProductDTO());
        } else {
            return null;
        }
    }

    @Override
    public void delete(ProductDTO productDTO) {
Optional <Product> product=productRepo.findById(productDTO.getId());
if (product.isPresent() && product.get().isDeleted()==false){
    product.get().setDeleted(true);
    product.get().setEnabled(false);
}
    }

    @Override
    public Product save(ProductDTO productDTO) {
        Product converted=mapperUtil.convert(productDTO,new Product());
        converted.setEnabled(true);
        productRepo.save(converted);
        return converted;
    }

    @Override
    public void update(ProductDTO productDTO) {
       Product product=productRepo.findByName(productDTO.getName());
       Product converted = mapperUtil.convert(productDTO,new Product());
       converted.setId(product.getId());
       productRepo.save(converted);



    }
}
