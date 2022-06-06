package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Policy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IProduct_PolicyRepository {

    @Query("SELECT policy FROM Product_Policy pp WHERE pp.product.id = ?1")
    Set<Policy> findPolicyByProductId(Long productId);
}
