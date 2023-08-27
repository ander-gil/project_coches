package com.project.project_coches.persistance.repository;

import com.project.project_coches.domain.pojo.BrandCarPojo;
import com.project.project_coches.domain.repository.IBrandCarRepository;
import com.project.project_coches.persistance.entity.BrandCarEntity;
import com.project.project_coches.persistance.mapper.IBrandCarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// @RequiredArgsConstructor se utiliza para crear constructor con los atributos final
@Repository
public class BrandCarRepository implements IBrandCarRepository {

    private final IBrandCarCrudRepository   iBrandCarCrudRepository;

    private final IBrandCarMapper iBrandCarMapper;

    @Autowired
    public BrandCarRepository(IBrandCarCrudRepository iBrandCarCrudRepository, IBrandCarMapper iBrandCarMapper) {
        this.iBrandCarCrudRepository = iBrandCarCrudRepository;
        this.iBrandCarMapper = iBrandCarMapper;
    }

    @Override
    public List<BrandCarPojo> getAll() {
        return iBrandCarMapper.toMarcasCochePojo(iBrandCarCrudRepository.findAll());
    }

    @Override
    public Optional<BrandCarPojo> getBrandCar(Integer id) {
        return iBrandCarCrudRepository.findById(id)
                .map(iBrandCarMapper::toMarcaCochePojo);
        // brandCarEntity -> iBrandCarMapper.toMarcaCochePojo(brandCarEntity) LAMBDA
        // iBrandCarMapper::toMarcaCochePojo Metodo por referencia
    }

    @Override
    public BrandCarPojo save(BrandCarPojo newBrandCar) {
      BrandCarEntity brandCarEntity =  iBrandCarMapper.toMarcaCocheEntity(newBrandCar);
      return iBrandCarMapper.toMarcaCochePojo(iBrandCarCrudRepository.save(brandCarEntity));
    }

    /**
     * Elimina una marca coche dado su id
     * @param id del coche a eliminar
     */
    @Override
    public void delete(Integer id) {
    iBrandCarCrudRepository.deleteById(id);
    }
}
