package application.controller.admin;

import application.dto.NewDTO;
import application.service.impl.CategoryService;
import application.service.impl.NewService;
import application.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class NewController {

    @Autowired
    private NewService newService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MessageUtils messageUtils;

    @RequestMapping(value = "/admin/new/list", method = RequestMethod.GET)
    public ModelAndView showNew(HttpServletRequest request) {
        NewDTO vm = new NewDTO();
        vm.setListResult(newService.findAll());
        ModelAndView modelAndView = new ModelAndView("/admin/new/list");
        if (request.getParameter("message") != null) {
           Map<String, String> message =  messageUtils.getMessage(request.getParameter("message"));
            modelAndView.addObject("message" , message.get("message"));
            modelAndView.addObject("alert" , message.get("alert"));
        }
        modelAndView.addObject("vm", vm);

        return modelAndView;
    }

    @RequestMapping(value = "/admin/new/edit", method = RequestMethod.GET)
    public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/admin/new/edit");
        NewDTO vm = new NewDTO();
        if (id != null) {
            vm = newService.findById(id);
        }
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtils.getMessage(request.getParameter("message"));
            modelAndView.addObject("message" , message.get("message"));
            modelAndView.addObject("alert" , message.get("alert"));
        }
        modelAndView.addObject("categories", categoryService.findAll());
        modelAndView.addObject("vm", vm);
        return modelAndView;
    }
}
