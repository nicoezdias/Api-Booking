package com.PI.apiBooking.Repository;

import com.PI.apiBooking.Model.Caracteristica;
import com.PI.apiBooking.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT COUNT(p) FROM Producto p WHERE p.category.title = ?1")
    Long countByCategory(String c);

    @Query("SELECT p FROM Producto p WHERE p.category.title = ?1")
    Set<Producto> buscarPorCategoria(String c);

}
