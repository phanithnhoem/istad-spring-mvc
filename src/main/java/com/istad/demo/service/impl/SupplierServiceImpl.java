package com.istad.demo.service.impl;

import com.istad.demo.model.Supplier;
import com.istad.demo.repository.SupplierRepository;
import com.istad.demo.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Override
    public List<Supplier> loadSuppliers() {
        return supplierRepository.selectSuppliers();
    }

    @Override
    public Supplier loadSupplierById(Integer id) {
        return supplierRepository.selectSupplierById(id).orElseThrow();
    }

    @Override
    public void createNewSupplier(Supplier supplier) {
        supplierRepository.insertSupplier(supplier);
    }

    @Override
    public void updateSupplierById(Integer id, Supplier supplier) {
        supplier.setId(id);
        supplier.setSince(LocalDate.now());
        supplierRepository.updateSupplier(supplier);
    }

    @Override
    public void deleteSupplierById(Integer id) {
        supplierRepository.deleteSupplier(id);
    }
}
