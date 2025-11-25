package com.backend.gestion.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.backend.gestion.entities.Camion;


@Repository
public interface CamionRepository extends JpaRepository<Camion, Long> {
    // Calcula el promedio de la columna consumo_promedio
    @Query("SELECT AVG(c.consumoPromedio) FROM Camion c")
    BigDecimal obtenerPromedioConsumo();

}


