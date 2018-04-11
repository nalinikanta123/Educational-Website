package project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import project.Models.*;
import project.Services.*;

@Controller
public class UserController {
	// TODO to be removed
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String showUsers(ModelMap modelMap) {
		modelMap.put("userlist", UserService.getAllUsers());
		return "user/Userlist";
	}

	@RequestMapping("/user/{id}")
	public String showUser(ModelMap model, @PathVariable int id) {
		model.put("user", UserService.getUser(id));
		return "user/Userinfo";
	}

	// TODO not valid password or username
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		return "user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkLogin(ModelMap modelMap, @RequestParam("username") String username,
			@RequestParam("password") String password) {

		if (UserService.checkValidLogin(username, password)) {
			return "redirect:/home";
		}
		return "user/login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model, @RequestParam("type") String type) {
		Account account = new Account();
		account.setType(type);
		
		model.addAttribute("account", account);
		return "user/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute(value = "account") Account account) {
		
		User user = UserFactory.getUser(account.getType());
		user.setAccount(account);
		
		UserService.addUser(user);
		System.out.println(user.getAccount().toString());
		
		UserService.loggedInUser = user;
		return "redirect:/home";

	}
}
