package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Caracteristica;
import com.PI.apiBooking.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ICaractericaRepository extends JpaRepository<Caracteristica,Long> {

    //    @Query("SELECT c FROM Caracteristica c WHERE c.name = ?1")
    //    Optional<Caracteristica> findByName(String name);

    @Query("SELECT c.products FROM Caracteristica c WHERE c.name = ?1")
    Set<Producto> buscarPorCaracteristica(String c);
}
