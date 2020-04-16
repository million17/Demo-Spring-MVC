package application.controller.web;

import application.entity.UserEntity;
import application.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
    @Autowired
    private IUserService userService;

    @GetMapping("/register")
    public ModelAndView register(Model model) {
        ModelAndView modelAndView = new ModelAndView("/login/register");
        modelAndView.addObject("user", new UserEntity());
        return modelAndView;
    }

    @RequestMapping(value = "/register-user", method = RequestMethod.POST)
    public ModelAndView registerNewUser(@Validated @ModelAttribute("user") UserEntity userEntity) {
        userService.registerNewUser(userEntity);

        return new ModelAndView("redirect:/login");
    }
}
