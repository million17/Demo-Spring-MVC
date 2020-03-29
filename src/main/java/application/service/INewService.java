package application.service;

import application.dto.NewDTO;

import java.util.List;

public interface INewService {
    List<NewDTO> findAll();
    NewDTO findById(long id);
    NewDTO save(NewDTO newDTO);
    void delete(long[] ids);
}
