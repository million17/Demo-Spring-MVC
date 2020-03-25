package application.service.impl;

import application.converter.CategoryConverter;
import application.dto.CategoryDTO;
import application.entity.CategoryEntity;
import application.repository.CategoryRepository;
import application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryConverter categoryConverter;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Map<String,String> findAll() {
        Map<String,String> result = new HashMap<>();
        List<CategoryEntity> entities = categoryRepository.findAll();
        for (CategoryEntity item : entities) {
            result.put(item.getCode(),item.getName());
        }
        return result;
    }
}
