package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICaractericaRepository extends JpaRepository<Caracteristica,Long> {

    //    @Query("SELECT c FROM Caracteristica c WHERE c.name = ?1")
    //    Optional<Caracteristica> findByName(String name);
}
