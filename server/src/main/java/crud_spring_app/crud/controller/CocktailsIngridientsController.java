package crud_spring_app.crud.controller;

import crud_spring_app.crud.model.Entity.CocktailsEntity;
import crud_spring_app.crud.model.Entity.CocktailsIngridientsEntity;
import crud_spring_app.crud.model.services.CocktailsIngridientsService;
import crud_spring_app.crud.model.services.CocktailsService;
import crud_spring_app.crud.model.services.IngridientsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CocktailsIngridientsController {
    @RequestMapping(value = "create-cocktail-ingridient", method = RequestMethod.POST)
    public CocktailsIngridientsEntity create(@RequestBody General general) {

        CocktailsEntity cocktailsEntity = new CocktailsEntity();

        cocktailsEntity.setName(general.getCocktailName());

        CocktailsEntity savedCocktailsEntity = CocktailsService.save(cocktailsEntity);

        System.out.println("Number: " + general.getIngridientsNames().length);

        for (int i = 0; i < general.getIngridientsNames().length; i++) {

            CocktailsIngridientsEntity cocktailsIngridientsEntity = new CocktailsIngridientsEntity();

            cocktailsIngridientsEntity.setCoctailId(savedCocktailsEntity.getId());

            cocktailsIngridientsEntity.setIngridientId(IngridientsService.find(general.getIngridientsNames()[i].getName()).getId());

            CocktailsIngridientsService.save(cocktailsIngridientsEntity);

        }
        return null;
    }

    @RequestMapping(value = "update-cocktail-ingridient", method = RequestMethod.PUT)
    public CocktailsIngridientsEntity update(@RequestBody CocktailsIngridientsEntity coctailsEntity) {
        return CocktailsIngridientsService.change(coctailsEntity);
    }

    @RequestMapping(value = "read-all-cocktail-ingridient", method = RequestMethod.GET)
    public List<CocktailsIngridientsEntity> readAll() {
        return CocktailsIngridientsService.findAll();
    }

    @RequestMapping(value = "read-cocktail-ingridient", method = RequestMethod.GET)
    public CocktailsIngridientsEntity read(@RequestBody String name) {
        return CocktailsIngridientsService.find(name);
    }

    @RequestMapping(value = "delete-cocktail-ingridient", method = RequestMethod.DELETE)
    public CocktailsIngridientsEntity delete(@RequestBody String name) {
        return CocktailsIngridientsService.remove(name);
    }

}
