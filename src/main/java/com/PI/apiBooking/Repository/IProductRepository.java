package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.category.id = ?1")
    List<Product> findByCategoryId(Long categoryId);

    @Query("SELECT p FROM Product p WHERE p.city.id = ?1")
    List<Product> findByCityId(Long cityId);

    @Query("SELECT AVG(r.score) FROM Rating r WHERE product.id = ?1")
    Optional<Integer> averageScoreByProduct(Long productId);

}
