package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFeatureRepository extends JpaRepository<Feature,Long> {
}
