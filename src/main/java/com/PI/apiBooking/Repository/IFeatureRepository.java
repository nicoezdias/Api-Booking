package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Feature;
import com.PI.apiBooking.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IFeatureRepository extends JpaRepository<Feature,Long> {

    //    @Query("SELECT f FROM Feature f WHERE f.name = ?1")
    //    Optional<feature> findByName(String name);

    @Query("SELECT products FROM Feature f WHERE f.name = ?1")
    Set<Product> findProductsByFeature(String featureName);
}
