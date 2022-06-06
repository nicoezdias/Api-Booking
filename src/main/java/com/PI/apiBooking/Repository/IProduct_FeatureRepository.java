package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Feature;
import com.PI.apiBooking.Model.Product_Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IProduct_FeatureRepository  extends JpaRepository<Product_Feature, Long> {

    @Query("SELECT feature FROM Product_Feature pf WHERE pf.product.id = ?1")
    Set<Feature> findFeaturesByProductId(Long productId);
}
