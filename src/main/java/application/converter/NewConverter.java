package application.converter;

import application.dto.NewDTO;
import application.entity.NewEntity;
import org.springframework.stereotype.Component;

@Component
public class NewConverter {

    public NewDTO toDTO(NewEntity entity){

        NewDTO result = new NewDTO();
        result.setId(entity.getId());
        result.setTitle(entity.getTitle());
        result.setContent(entity.getContent());
        result.setShortDesc(entity.getShortDesc());
        result.setThumbnail(entity.getThumbnail());
        result.setCategoryCode(entity.getCategory().getCode());
        return result;
    }


    public NewEntity toEntity(NewDTO dto){
        NewEntity result = new NewEntity();
        result.setTitle(dto.getTitle());
        result.setContent(dto.getContent());
        result.setShortDesc(dto.getShortDesc());
        result.setThumbnail(dto.getThumbnail());

        return result;

    }

}
