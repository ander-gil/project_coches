package com.project.project_coches.domain.service;

import com.project.project_coches.domain.pojo.BrandCarPojo;

import java.util.List;
import java.util.Optional;

public interface IBrandCarService {
    /**
     * Devuelve una lista con todos las marcas de coches
     * @return Lista con  las marcas de los coches
     */
    List<BrandCarPojo> getAll();

    /**
     * Devuelve una marca de coche dodo su id
     * @param id de marca del coche
     * @return optional de la marca de coche encontrada
     */
    Optional<BrandCarPojo> getBrandCar(Integer id);

    /**
     * Guardar una nueva marca de coche
     * @param newBrandCar Marca coche a guardar
     * @return Marca coche guardado
     */
    BrandCarPojo save (BrandCarPojo newBrandCar);

    /**
     * Actualiza una marca coche
     * @param newBrandCar marca coche a actualizar
     * @return Marca coche actualizada
     */
    Optional<BrandCarPojo> update (BrandCarPojo newBrandCar);


    /**
     * Elimina una marca de coche dado su id
     * @param id del coche a eliminar
     * @return true si se elimino false de lo contrario
     */
    boolean delete(Integer id);
}
