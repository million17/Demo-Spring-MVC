package application.service.impl;

import application.converter.NewConverter;
import application.dto.NewDTO;
import application.entity.CategoryEntity;
import application.entity.NewEntity;
import application.repository.CategoryRepository;
import application.repository.NewRepository;
import application.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewService implements INewService {

    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;


    @Override
    public List<NewDTO> findAll() {
        List<NewDTO> models = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll();
        for (NewEntity item : entities) {
            NewDTO newDTO = newConverter.toDTO(item);
            models.add(newDTO);
        }
        return models;
    }

    @Override
    public NewDTO findById(int id) {
        NewEntity entity = newRepository.findOne(id);
        return newConverter.toDTO(entity);
    }


    @Override
    public NewDTO save(NewDTO newDTO) {
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
        NewEntity newEntity = new NewEntity();
        if(newDTO.getId() != 0 ) {
            NewEntity oldNew = newRepository.findOne(newDTO.getId());
            oldNew.setCategory(categoryEntity);
            newEntity = newConverter.toEntity(oldNew, newDTO);
        } else {
            newEntity = newConverter.toEntity(newDTO);
            newEntity.setCategory(categoryEntity);
        }
        return newConverter.toDTO(newRepository.save(newEntity));
    }

    @Override
    public void delete(int[] ids) {
        for (int id : ids ) {
            newRepository.delete(id);
        }

    }
}
