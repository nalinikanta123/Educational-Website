package project.Controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.Models.Game.*;
import project.Services.*;
@Controller
public class CategoryController {
	
	@RequestMapping(method = RequestMethod.GET, value = "category/{categoryName}")
	public String viewGamesOfCategory(ModelMap model, @PathVariable String categoryName) {
		ArrayList<GameDetails> listOfGameDetails = CategoryService.getGameDetailsOfCategory(categoryName);
		
		
		model.put("categoryName", categoryName);
		model.put("listOfGameDetails", listOfGameDetails);
		
		return "category/view/categoryGames";
	}

}
