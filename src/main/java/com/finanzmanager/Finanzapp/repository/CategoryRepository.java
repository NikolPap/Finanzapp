package com.finanzmanager.Finanzapp.repository;

import com.finanzmanager.Finanzapp.model.Category;
import com.finanzmanager.Finanzapp.model.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    //Query-Methode
    List<Category> findByType(CategoryType type);

    //Query mit JPQL
    @Query("select c from Category c where c.name like  %:keyword%")
    List<Category> searchByName(@Param("keyword") String keyword);

}
