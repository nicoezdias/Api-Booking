package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Categoria;
import com.PI.apiBooking.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {

    //    @Query("SELECT c FROM Categoria c WHERE c.title = ?1")
    //    Optional<Categoria> findByTitle(String title);

}
