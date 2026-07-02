package com.finanzmanager.Finanzapp.service;

import com.finanzmanager.Finanzapp.model.Category;
import com.finanzmanager.Finanzapp.model.CategoryType;
import com.finanzmanager.Finanzapp.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //create
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    //Read alle
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    //get by type
    public List<Category> getByType(CategoryType type) {
        return categoryRepository.findByType(type);
    }

    //search by name
    public List<Category> searchByName(String keyword) {
        return categoryRepository.searchByName(keyword);
    }

    //read nach Id
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("kategorie mit ID " + id + " nicht gefunden"));
    }

    //update
    public Category updateCategory(Long id, Category updatedCategory) {
      Category existngCategory = getCategoryById(id);

      existngCategory.setName(updatedCategory.getName());
      existngCategory.setType(updatedCategory.getType());
      return categoryRepository.save(existngCategory);
    }

    //delete

    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("kategorie " + id + " nicht gefunden");
        }else {
            categoryRepository.deleteById(id);
        }
    }
}
