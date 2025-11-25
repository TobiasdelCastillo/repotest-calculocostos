package com.backend.logistica.entities.dto.external;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class TarifasVigentesDto {
    private BigDecimal precioLitroCombustible;
    private BigDecimal cargoGestionFijo;
    private BigDecimal costoEstadiaDiaria;
    // Puedes agregar más según tu lógica de tarifas

    
}