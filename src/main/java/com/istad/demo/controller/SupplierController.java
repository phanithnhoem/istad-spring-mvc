package com.istad.demo.controller;

import com.istad.demo.model.Supplier;
import com.istad.demo.repository.SupplierRepository;
import com.istad.demo.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<Supplier> getSuppliers(){
        return supplierService.loadSuppliers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    Supplier getSupplierById(@PathVariable Integer id){
        return supplierService.loadSupplierById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addNewSupplier(@RequestBody Supplier supplier){
        supplier.setSince(LocalDate.now());
        supplier.setStatus(true);
        supplierService.createNewSupplier(supplier);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateSupplierById(@PathVariable Integer id, @RequestBody Supplier supplier){
        supplierService.updateSupplierById(id, supplier);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteSupplierById(@PathVariable Integer id){
        supplierService.deleteSupplierById(id);
    }

}
