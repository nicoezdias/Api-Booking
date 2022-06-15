package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.User.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository  extends JpaRepository<Rol,Long> {

}
