package com.cybertek.repo;

import com.cybertek.entity.Category;
import com.cybertek.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
   Product findByName(String name);
   List<Product>findAllByLowLimitAlert();
}
