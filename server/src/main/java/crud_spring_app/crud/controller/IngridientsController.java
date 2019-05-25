package crud_spring_app.crud.controller;

import crud_spring_app.crud.model.Entity.IngridientsEntity;
import crud_spring_app.crud.model.services.IngridientsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngridientsController {

    @RequestMapping(value = "create-ingridient", method = RequestMethod.POST)
    public IngridientsEntity create(@RequestBody IngridientsEntity ingridientsEntity) {
        return IngridientsService.save(ingridientsEntity);
    }

    @RequestMapping(value = "update-ingridient", method = RequestMethod.PUT)
    public IngridientsEntity update(@RequestBody IngridientsEntity coctailsEntity) {
        return IngridientsService.change(coctailsEntity);
    }

    @RequestMapping(value = "read-all-ingridients", method = RequestMethod.GET)
    public List<IngridientsEntity> readAll() {
        return IngridientsService.findAll();
    }

    @RequestMapping(value = "read-ingridient", method = RequestMethod.GET)
    public IngridientsEntity read(@RequestBody String name) {
        return IngridientsService.find(name);
    }

    @RequestMapping(value = "delete-ingridient", method = RequestMethod.DELETE)
    public IngridientsEntity delete(@RequestBody String name) {
        return IngridientsService.remove(name);
    }
}
