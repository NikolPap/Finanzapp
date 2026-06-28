package com.finanzmanager.Finanzapp.repository;

import com.finanzmanager.Finanzapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
