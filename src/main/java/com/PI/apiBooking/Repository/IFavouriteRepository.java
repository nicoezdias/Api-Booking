package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Entity.Favourite;
import com.PI.apiBooking.Model.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFavouriteRepository extends JpaRepository<Favourite,Long> {

    @Query("SELECT f.product FROM Favourite f WHERE f.user.id = ?1")
    List<Product> findProductsByUserId(Long userId);

    @Query(value = "SELECT f FROM Favourite f WHERE f.user.id = ?1 AND f.product.id = ?1")
    Optional<Favourite> findByUserIdAndProductId(Long userId, Long productId);
}
