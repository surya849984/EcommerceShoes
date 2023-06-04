package com.Ecom.Project03.Repo;

import com.Ecom.Project03.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    // Add custom query methods if needed
}
