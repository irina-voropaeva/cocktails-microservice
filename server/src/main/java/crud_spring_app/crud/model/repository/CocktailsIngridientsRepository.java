package crud_spring_app.crud.model.repository;


import crud_spring_app.crud.model.Entity.CocktailsEntity;
import crud_spring_app.crud.model.Entity.CocktailsIngridientsEntity;
import crud_spring_app.crud.model.repository.manager.Manager;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;

@Repository("cocktailsIngridientsRepository")
public class CocktailsIngridientsRepository {

    public static void add(CocktailsIngridientsEntity entity) {
        Manager.getEm().getTransaction().begin();
        Manager.getEm().persist(entity);
        Manager.getEm().getTransaction().commit();
    }

    public static CocktailsIngridientsEntity find(CocktailsIngridientsEntity entity) {
        Query query = Manager.getEm().createQuery("SELECT entity FROM IngridientsEntity entity WHERE id = ?1", CocktailsIngridientsEntity.class);
        query.setParameter(1, entity.getId());

        return (CocktailsIngridientsEntity) query.getSingleResult();
    }

    public static ArrayList<CocktailsIngridientsEntity> find(CocktailsEntity entity) {
        Query query = Manager.getEm().createQuery("SELECT entity FROM CocktailsIngridientsEntity entity WHERE coctailId = ?1", CocktailsIngridientsEntity.class);
        query.setParameter(1, entity.getId());

        return (ArrayList) query.getResultList();
    }

    public static void update(CocktailsIngridientsEntity entity) {
        Manager.getEm().getTransaction().begin();
        Manager.getEm().persist(entity);
        Manager.getEm().getTransaction().commit();
    }

    public static void delete(CocktailsIngridientsEntity entity) {
        Manager.getEm().getTransaction().begin();
        Manager.getEm().remove(entity);
        Manager.getEm().getTransaction().commit();
    }

    public static ArrayList<CocktailsIngridientsEntity> findAll() {
        Query query = Manager.getEm().createQuery("SELECT entity FROM IngridientsEntity entity", CocktailsIngridientsEntity.class);
        ArrayList<CocktailsIngridientsEntity> resultList = (ArrayList<CocktailsIngridientsEntity>) query.getResultList();
        return resultList;
    }

}
