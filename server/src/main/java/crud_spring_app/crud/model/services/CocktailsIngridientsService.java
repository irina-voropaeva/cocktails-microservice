package crud_spring_app.crud.model.services;


import crud_spring_app.crud.model.Entity.CocktailsEntity;
import crud_spring_app.crud.model.Entity.CocktailsIngridientsEntity;
import crud_spring_app.crud.model.Entity.IngridientsEntity;
import crud_spring_app.crud.model.repository.CocktailsIngridientsRepository;
import crud_spring_app.crud.model.repository.CocktailsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("cocktailsIngridientsService")
public class CocktailsIngridientsService {

    public static boolean isAlchohol() {
        return alchohol;
    }

    public static void setAlchohol(boolean alc) {
        alchohol = alc;
    }

    private static boolean alchohol = false;

    public static CocktailsIngridientsEntity save(CocktailsIngridientsEntity entity) {
        CocktailsIngridientsRepository.add(entity);
        return entity;
    }

    public static CocktailsIngridientsEntity find(String name) {

        CocktailsIngridientsEntity entity = new CocktailsIngridientsEntity();
        long id = CocktailsService.findByName(name).getId();
        entity.setCoctailId(id);
        return CocktailsIngridientsRepository.find(entity);
    }

    public static IngridientsEntity[] findIngridientsOfCocktail(CocktailsEntity entity) {
        ArrayList<CocktailsIngridientsEntity> cocktailsIngridientsEntity = CocktailsIngridientsRepository.find(entity);
        IngridientsEntity[] ingridientsEntities = new IngridientsEntity[cocktailsIngridientsEntity.size()];
        for (int i = 0; i < cocktailsIngridientsEntity.size(); i++) {
            ingridientsEntities[i] = IngridientsService.find((int) cocktailsIngridientsEntity.get(i).getIngridientId());
            if (ingridientsEntities[i].isAlcohol()) {
                alchohol = true;
            }
        }

        return ingridientsEntities;

    }

    public static void change(String name) {
        CocktailsEntity entity = new CocktailsEntity();
        entity.setName(name);
        CocktailsRepository.update(entity);
    }

    public static CocktailsIngridientsEntity change(CocktailsIngridientsEntity entity) {
        CocktailsIngridientsRepository.update(entity);
        return entity;
    }

    public static CocktailsIngridientsEntity remove(String name) {

        CocktailsIngridientsEntity entity;
        entity = CocktailsIngridientsService.find(name);
        CocktailsIngridientsRepository.delete(entity);
        return entity;
    }

    public static List<CocktailsIngridientsEntity> findAll() {
        return CocktailsIngridientsRepository.findAll();
    }
}
