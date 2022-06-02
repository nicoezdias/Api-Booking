package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IImageRepository extends JpaRepository<Image, Long> {

    @Query("FROM Image i where i.product.id= ?1")
    Set<Image> getImagesByProduct(Long id);
}
