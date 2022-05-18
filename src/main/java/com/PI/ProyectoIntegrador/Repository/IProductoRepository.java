package com.PI.ProyectoIntegrador.Repository;

import com.PI.ProyectoIntegrador.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
