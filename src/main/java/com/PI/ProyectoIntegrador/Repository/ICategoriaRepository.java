package com.PI.ProyectoIntegrador.Repository;

import com.PI.ProyectoIntegrador.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {
}
