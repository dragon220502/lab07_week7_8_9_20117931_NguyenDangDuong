package com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.repositories;


import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.dto.ProductDto;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.enums.CartStatus;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select new com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.dto(p.id,p.name,pp.price,pi.path,p.description) from Product p join ProductPrice pp on p.id=pp.product.id join ProductImage pi on pi.product.id=p.id where p.status=0")
    List<ProductDto> getProduct();
    @Query("select new com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.dto(p.id,p.name,pp.price,pi.path,p.description) from Product p join ProductPrice pp on p.id=pp.product.id join ProductImage pi on pi.product.id=p.id join Cart c on c.id.product.id=p.id where p.status=0 and c.id.user.userName=:userName and pi.alternative like 'cart' and c.status=:status")
    List<ProductDto> getProduct(@Param("userName") String userName, @Param("status") CartStatus cartStatus);
    @Query("select new com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.dto(p.id,p.name,pp.price,pi.path,p.description) from Product p join ProductPrice pp on p.id=pp.product.id join ProductImage pi on pi.product.id=p.id where p.status=0 and pi.alternative='product'")
    Page<ProductDto> getProduct(Pageable pageable);
    @Query("select new com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.dto(p.id,p.name,pp.price,pi.path,p.description) from Product p join ProductPrice pp on p.id=pp.product.id join ProductImage pi on pi.product.id=p.id where p.status=0 and pi.alternative='product-details' and p.id=:id" )
    Optional<ProductDto> findByProdId(@Param("id") Long id);
}
