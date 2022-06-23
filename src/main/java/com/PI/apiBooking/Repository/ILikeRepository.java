package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Entity.Like;
import com.PI.apiBooking.Model.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILikeRepository extends JpaRepository<Like,Long> {

    @Query("SELECT l.product FROM Like l WHERE l.user.id = ?1")
    List<Product> findProductsByUserId(Long userId);

    @Query(value = "SELECT l FROM Like l WHERE l.user.id = ?1 AND l.product.id = ?1")
    Optional<Like> findByUserIdAndProductId(Long userId, Long productId);
}
