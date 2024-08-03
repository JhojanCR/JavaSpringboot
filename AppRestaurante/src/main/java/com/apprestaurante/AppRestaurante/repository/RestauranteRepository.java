package com.apprestaurante.AppRestaurante.repository;

import com.apprestaurante.AppRestaurante.model.Restaurante;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface RestauranteRepository extends JpaRepository <Restaurante, Long> {
}
