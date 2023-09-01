package com.project.project_coches.controller;

import com.project.project_coches.domain.pojo.BrandCarPojo;
import com.project.project_coches.domain.service.IBrandCarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * controlador rest de marca coche
 */
@RestController
@RequestMapping(path = "/marcas-coches")
public class BranCarController {


    private final IBrandCarService iBrandCarService;

    public BranCarController(IBrandCarService iBrandCarService) {
        this.iBrandCarService = iBrandCarService;
    }

    @GetMapping()
    public ResponseEntity<List<BrandCarPojo>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iBrandCarService.getAll());
        // return new ResponseEntity<>(iBrandCarService.getAll(), HttpStatus.OK); Alternativa para crear ResponseEntity
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<BrandCarPojo> getBrandCar(@PathVariable Integer id){
        return ResponseEntity.of(iBrandCarService.getBrandCar(id));
    }

    @PostMapping()
    public ResponseEntity<BrandCarPojo> save (@RequestBody  BrandCarPojo newBrandCar){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarService.save(newBrandCar));
        }catch (Exception e){
            //corregir
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Actualiza una marca coche
     * @param brandCarPojoUpdate marca coche a guardar
     * @return Optional con marca coche actualizada
     */
    @PatchMapping()
    public ResponseEntity<BrandCarPojo> update(@RequestBody BrandCarPojo brandCarPojoUpdate){
        return ResponseEntity.of(iBrandCarService.update(brandCarPojoUpdate));
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Boolean> delete (@PathVariable Integer id){
        return new ResponseEntity<>(this.iBrandCarService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
