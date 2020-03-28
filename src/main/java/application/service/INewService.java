package application.service;

import application.dto.NewDTO;

import java.util.List;

public interface INewService {
    List<NewDTO> findAll();
    NewDTO findById(long id);
    NewDTO insert(NewDTO dto);
    NewDTO update(NewDTO updateNew);
}
