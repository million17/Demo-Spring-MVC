package application.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import application.model.New;
import application.service.INewService;

@Controller(value = "newControllerOfAdmin")
public class NewController {

	@Autowired
	private INewService newService;

	@RequestMapping(value = "/admin/new/list", method = RequestMethod.GET)
	public ModelAndView showList(@ModelAttribute("model") New model) {
		ModelAndView mav = new ModelAndView("admin/new/list");
		model.setListResult(newService.findAll());
		mav.addObject("vm", model);
		return mav;
	}

	@RequestMapping(value = "/admin/new/edit", method = RequestMethod.GET)
	public ModelAndView editNew() {
		ModelAndView mav = new ModelAndView("admin/new/edit");
		return mav;
	}

}