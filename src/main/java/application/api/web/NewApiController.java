package application.api.web;

import application.dto.NewDTO;
import application.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "newApiOfWeb")
public class NewApiController {

    @Autowired
    private INewService newService;


    @PostMapping("/api/new")
    public NewDTO createNew(@RequestBody NewDTO newDTO) {
        return newService.save(newDTO);
    }

    @PutMapping("/api/new")
    public NewDTO updateNew(@RequestBody NewDTO newDTO) {
        return newService.save(newDTO);
    }

    @DeleteMapping("/api/new")
    public void deleteNew(@RequestBody long[] ids) {
        newService.delete(ids);
    }
}
