package com.project.project_coches.domain.service;

import com.project.project_coches.domain.pojo.BrandCarPojo;
import com.project.project_coches.domain.repository.IBrandCarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * servicio de marca coche
 */
@Service
public class BrandCarService implements IBrandCarService {

    /**
     * Repositorio de marca coche
     */
    private final IBrandCarRepository iBrandCarRepository;

    public BrandCarService(IBrandCarRepository iBrandCarRepository) {
        this.iBrandCarRepository = iBrandCarRepository;
    }

    @Override
    public List<BrandCarPojo> getAll() {
        return iBrandCarRepository.getAll();
    }

    @Override
    public Optional<BrandCarPojo> getBrandCar(Integer id) {
        return iBrandCarRepository.getBrandCar(id);
    }

    @Override
    public BrandCarPojo save(BrandCarPojo newBrandCar) {
        return iBrandCarRepository.save(newBrandCar);
    }

    @Override
    public boolean delete(Integer id) {
        try {
            iBrandCarRepository.delete(id);
            return true;
        }catch (Exception e) {
            return  false;
        }
    }
}
