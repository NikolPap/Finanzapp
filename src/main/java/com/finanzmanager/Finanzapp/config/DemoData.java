package com.finanzmanager.Finanzapp.config;

import com.finanzmanager.Finanzapp.model.Category;
import com.finanzmanager.Finanzapp.model.CategoryType;
import com.finanzmanager.Finanzapp.repository.CategoryRepository;
import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoData {

    @Bean
    CommandLineRunner loadSampleData(CategoryRepository repository, CategoryRepository categoryRepository) {
        return args -> {
            Category c = new Category();
            c.setName("Lebensmittel");
            c.setType(CategoryType.AUSGABE);
            categoryRepository.save(c);

            System.out.println("Beispiel-Kategorie gespeichert");
        };
    }
}
