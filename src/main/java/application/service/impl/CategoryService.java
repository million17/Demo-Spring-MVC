package application.service.impl;

import application.converter.CategoryConverter;
import application.dto.CategoryDTO;
import application.entity.CategoryEntity;
import application.repository.CategoryRepository;
import application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryConverter categoryConverter;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> findAll() {
        List<CategoryDTO> models = new ArrayList<>();
        List<CategoryEntity> entities = categoryRepository.findAll();
        for (CategoryEntity item : entities) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryConverter.toDTO(item);
            models.add(categoryDTO);
        }
        return models;
    }
}
