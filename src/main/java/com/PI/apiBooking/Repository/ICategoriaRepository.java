package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {

    //    @Query("SELECT c FROM Categoria c WHERE c.title = ?1")
    //    Optional<Categoria> findByTitle(String title);
}
