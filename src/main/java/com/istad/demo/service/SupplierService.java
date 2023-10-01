package com.istad.demo.service;

import com.istad.demo.model.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> loadSuppliers();
    Supplier loadSupplierById(Integer id);
    void createNewSupplier(Supplier supplier);
    void updateSupplierById(Integer id, Supplier supplier);
    void deleteSupplierById(Integer id);
}
