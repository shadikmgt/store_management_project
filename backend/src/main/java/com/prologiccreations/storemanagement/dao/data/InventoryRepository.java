package com.prologiccreations.storemanagement.dao.data;

import com.prologiccreations.storemanagement.dao.super_classes.CrudDao;
import com.prologiccreations.storemanagement.model.data.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>, CrudDao<Inventory, Long> {


    @Modifying
    @Query(value = "UPDATE Inventory e " +
            "SET e.active = false, e.modifiedBy = :modifiedBy, e.modifiedDate = :modifiedDate " +
            "where e.id = :id")
    int softDeleteById(@Param("id") Long id, @Param("modifiedBy") String modifiedBy, @Param("modifiedDate") LocalDateTime modifiedDate);

}