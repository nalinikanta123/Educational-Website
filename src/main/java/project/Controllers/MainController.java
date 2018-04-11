package project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.Services.*;


@Controller
public class MainController {	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap modelMap) {
		modelMap.put("categoryList", CategoryService.getCategories());
		
		return "home";
	}
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {		
		return "welcome";
	}
	
	// TODO no POST for home
}
