package application.service;

import application.dto.NewDTO;

import java.util.List;

public interface INewService {
    List<NewDTO> findAll();
    NewDTO findById(int id);
    NewDTO save(NewDTO newDTO);
    void delete(int[] ids);
}
