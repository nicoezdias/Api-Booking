package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Long> {


}
