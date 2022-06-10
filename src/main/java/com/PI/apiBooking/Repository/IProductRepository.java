package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Booking;
import com.PI.apiBooking.Model.Product;
import org.hibernate.type.BigIntegerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
=======
import java.math.BigInteger;
>>>>>>> back-dami
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

    @Query(value = "SELECT * FROM PRODUCT AS P  WHERE P.CITY_ID = ?3 AND P.ID NOT IN(" +
            "SELECT BOOKING.PRODUCT_ID FROM BOOKING WHERE " +
            "?1 BETWEEN BOOKING.ARRIVAL AND BOOKING.DEPARTURE OR" +
            "?2 BETWEEN BOOKING.ARRIVAL AND BOOKING.DEPARTURE OR" +
            "(?1 < BOOKING.ARRIVAL AND ?2 > BOOKING.DEPARTURE)" +
            ")", nativeQuery = true)
    List<Product> findByDateAndCityId(String arrival, String departure, int id);

}
