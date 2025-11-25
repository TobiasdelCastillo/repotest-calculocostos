package com.backend.gestion.services;
import org.springframework.stereotype.Service;

import com.backend.gestion.services.interfaces.CamionService;

import com.backend.gestion.entities.Camion;
import com.backend.gestion.repositories.CamionRepository;

import java.math.BigDecimal;
import java.util.List;


@Service
public class CamionServiceImpl implements CamionService {
    
    private final CamionRepository camionRepository;

    public CamionServiceImpl(CamionRepository camionRepository) {
        this.camionRepository = camionRepository;
    }

    @Override
    public List<Camion> getAllCamiones() {
        return camionRepository.findAll();
    }

    @Override
    public Camion getCamionPorId(Long id){
        return camionRepository.findById(id).orElse(null);
    }

    @Override
    public Camion createCamion(Camion camion) {
        return camionRepository.save(camion);
    }

    @Override
    public Camion updateCamion(Long id, Camion camion) {
        if (camionRepository.existsById(id)) {
            camion.setId(id);
            return camionRepository.save(camion);
        }
        return null; // se
        }

    @Override
    public void deleteCamion(Long id) {
        camionRepository.deleteById(id);
    }

    @Override
    public Camion getCamionById(Long id) {
        return camionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Camión no encontrado con id: " + id));
    }

    @Override
    public BigDecimal getConsumoPromedioFlota() {
        BigDecimal promedio = camionRepository.obtenerPromedioConsumo();
        // Si no hay camiones, devolvemos 0 para evitar null pointer
        return promedio != null ? promedio : BigDecimal.ZERO;
    }

}
