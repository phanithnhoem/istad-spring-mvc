package com.istad.demo.repository;

import com.istad.demo.model.Supplier;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface SupplierRepository {

    @Select("SELECT * FROM suppliers WHERE id = #{id}")
    Supplier selectProductSupplier(Integer id);

    @Select("SELECT * FROM suppliers")
    List<Supplier> selectSuppliers();

    @Select("SELECT * FROM suppliers WHERE id = #{id}")
    Optional<Supplier> selectSupplierById(Integer id);

    @Insert("INSERT INTO suppliers (company, since, status) VALUES (#{s.company}, #{s.since}, #{s.status})")
    void insertSupplier(@Param("s") Supplier supplier);

    @Update("UPDATE suppliers SET company = #{s.company}, status = #{s.status} WHERE id = #{s.id}")
    void updateSupplier(@Param("s") Supplier supplier);

    @Delete("DELETE FROM suppliers WHERE id = #{id}")
    void deleteSupplier(Integer id);

}
