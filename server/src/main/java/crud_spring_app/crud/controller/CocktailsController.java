package crud_spring_app.crud.controller;

import crud_spring_app.crud.model.Entity.CocktailsEntity;
import crud_spring_app.crud.model.services.CocktailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CocktailsController {

  @RequestMapping("/")
  public String home() {
    return "index";
  }

  @RequestMapping(value = "create-cocktail", method = RequestMethod.POST)
  public CocktailsEntity create(@RequestBody CocktailsEntity cocktailsEntity) {
    return CocktailsService.save(cocktailsEntity);
  }

  @RequestMapping(value = "update-cocktail", method = RequestMethod.PUT)
  public CocktailsEntity update(@RequestBody CocktailsEntity cocktailsEntity) {
    return CocktailsService.change(cocktailsEntity);
  }

  @RequestMapping(value = "read-all-cocktail", method = RequestMethod.GET)
  public List<General> readAll() {
    return CocktailsService.getToFrontAll();
  }

  @RequestMapping(value = "read-cocktail", method = RequestMethod.GET)
  public CocktailsEntity read(@RequestBody int id) {
    return CocktailsService.find(id);
  }

  @RequestMapping(value = "delete-cocktail", method = RequestMethod.DELETE)
  public CocktailsEntity delete(@RequestBody int id) {
    return CocktailsService.remove(id);
  }
}