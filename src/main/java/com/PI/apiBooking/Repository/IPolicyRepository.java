package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPolicyRepository extends JpaRepository<Policy, Long> {


}
