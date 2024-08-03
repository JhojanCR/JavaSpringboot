package com.apprestaurante.AppRestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apprestaurante.AppRestaurante.model.Cliente; // Asegúrate de que esta sea la ruta correcta a tu clase Cliente

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
