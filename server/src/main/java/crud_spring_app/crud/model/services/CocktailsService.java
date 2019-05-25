package crud_spring_app.crud.model.services;

import crud_spring_app.crud.controller.General;
import crud_spring_app.crud.model.Entity.CocktailsEntity;
import crud_spring_app.crud.model.Entity.IngridientsEntity;
import crud_spring_app.crud.model.repository.CocktailsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("coctailsService")
public class CocktailsService {

    public static CocktailsEntity save(CocktailsEntity entity) {
        CocktailsRepository.add(entity);
        return entity;

    }
    public static CocktailsEntity find(long id) {
        CocktailsEntity entity = new CocktailsEntity();
        entity.setId(id);
        return CocktailsRepository.find(entity);
    }

    public static CocktailsEntity findByName(String name) {
        CocktailsEntity entity = new CocktailsEntity();
        entity.setName(name);
        return CocktailsRepository.find(entity);
    }
    public static CocktailsEntity change(CocktailsEntity entity) {
        CocktailsRepository.update(entity);
        return entity;
    }
    public static CocktailsEntity remove(long id) {
        CocktailsEntity entity = new CocktailsEntity();
        entity.setId(id);
        CocktailsRepository.delete(entity);
        return entity;
    }

    public static List<CocktailsEntity> findAll() {
        return CocktailsRepository.findAll();
    }

    public static General getToFront(CocktailsEntity entity) {

        General general = new General();
        general.setCocktailName(entity.getName());

        IngridientsEntity[] ingridientsEntities = CocktailsIngridientsService.findIngridientsOfCocktail(entity);

        general.setIngridientsNames(ingridientsEntities);

        general.setAlchohol(CocktailsIngridientsService.isAlchohol());

        return general;

    }

    public static ArrayList<General> getToFrontAll() {
        ArrayList<CocktailsEntity> cocktailsEntities = new ArrayList<>(CocktailsService.findAll());


        ArrayList<General> general = new ArrayList<>();

        for (int i = 0; i < cocktailsEntities.size(); i++) {
            general.add(new General());
            general.get(i).setCocktailName(cocktailsEntities.get(i).getName());

            IngridientsEntity[] ingridientsEntities = CocktailsIngridientsService.findIngridientsOfCocktail(cocktailsEntities.get(i));

            general.get(i).setIngridientsNames(ingridientsEntities);
            for (int j = 0; j < ingridientsEntities.length; j++) {
                if (ingridientsEntities[j].isAlcohol()) {
                    general.get(i).setAlchohol(true);
                    break;
                }

            }
        }
        return general;


    }
}
