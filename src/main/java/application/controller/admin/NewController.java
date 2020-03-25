package application.controller.admin;

import application.dto.NewDTO;
import application.service.impl.CategoryService;
import application.service.impl.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewController {

    @Autowired
    private NewService newService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/admin/new/list", method = RequestMethod.GET)
    public ModelAndView showNew() {
        NewDTO vm = new NewDTO();
        vm.setListResult(newService.findAll());
        ModelAndView modelAndView = new ModelAndView("/admin/new/list");
        modelAndView.addObject("vm",vm);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/new/edit/", method = RequestMethod.GET)
    public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView("/admin/new/edit");
        NewDTO vm = new NewDTO();
        if (id != null) {
            vm = newService.findById(id);
        }
        modelAndView.addObject("categories", categoryService.findAll());
        modelAndView.addObject("vm", vm);
        return modelAndView;
    }
}
