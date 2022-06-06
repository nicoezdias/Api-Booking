package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPolicyRepository extends JpaRepository<Policy, Long> {

    //@Query("SELECT p FROM Policy p where i.product.id= ?1")
    //Policy findPolicyByProductId(Long productId);
}
