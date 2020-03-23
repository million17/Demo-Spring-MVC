package application.api.web;

import application.dto.NewDTO;
import org.springframework.web.bind.annotation.*;

@RestController(value = "newApiOfWeb")
public class NewApiController {

    @PostMapping("/api/new")
    public NewDTO createNew(@RequestBody NewDTO newDTO) {
        return newDTO;
    }

    @PutMapping("/api/new")
    public NewDTO updateNew(@RequestBody NewDTO newDTO) {
        return newDTO;
    }

    @DeleteMapping("/api/new")
    public void deleteNew(@RequestBody long[] ids) {

    }
}
