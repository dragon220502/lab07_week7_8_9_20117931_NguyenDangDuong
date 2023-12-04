package com.example.lab07_week07_8_9_20117931_nguyendangduong;

import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.Product;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.ProductImage;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.models.ProductPrice;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.services.ProductImageService;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.services.ProductPriceService;
import com.example.lab07_week07_8_9_20117931_nguyendangduong.backend.services.ProductService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootApplication
public class Lab07Week078920117931NguyenDangDuongApplication {
    @Qualifier("productImplement")
    @Autowired
    private ProductService service;
    @Autowired
    private ProductPriceService productPriceService;
    @Autowired
    private ProductImageService productImageService;
    @Bean
    CommandLineRunner init() {
        return args -> {
            int pr=1;
            int prd=1;
            int cart=1;
            int thumb=1;
            for (int i = 0; i < 1000; i++) {
                Faker faker = new Faker();
                Product p = new Product();
                p.setName(faker.commerce().productName());
                p.setDescription(faker.lorem().sentence());
                p.setUnit(faker.commerce().material());
                p.setManufacturer(faker.company().name());
                p.setStatus(ProductStatus.ACTIVE);
                service.save(p);
                Optional<Product> pf = service.findById(i+1);
                if(pf.isPresent()){
                    p = pf.get();
                    ProductImage image = new ProductImage(pr + "", "product", p);
                    ProductImage image2 = new ProductImage(prd + "", "product-details", p);
                    ProductImage image3 = new ProductImage(cart + "", "cart", p);
                    ProductImage image4 = new ProductImage(thumb + "", "thumb", p);
                    if(pr==12){
                        pr=0;
                    }
                    if(prd==5){
                        prd=0;
                    }
                    if(cart==3){
                        cart=0;
                    }
                    if(thumb==4){
                        thumb=0;
                    }
                    thumb++;
                    cart++;
                    prd++;
                    pr=pr+1;
                    productImageService.save(image);
                    productImageService.save(image2);
                    productImageService.save(image3);
                    productImageService.save(image4);
                    LocalDateTime currentTime = LocalDateTime.now().plusHours(i);
                    ProductPrice price = new ProductPrice();
                    price.setProduct(p);
                    price.setPriceDatetime(currentTime);
                    price.setPrice(Double.parseDouble(faker.commerce().price()));
                    price.setNote("Note no " + (i + 1));
                    productPriceService.save(price);
                }
            }
        }
                ;
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab07Week078920117931NguyenDangDuongApplication.class, args);
    }

}
