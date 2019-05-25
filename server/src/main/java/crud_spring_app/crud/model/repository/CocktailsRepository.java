package crud_spring_app.crud.model.repository;

import crud_spring_app.crud.model.Entity.CocktailsEntity;
import crud_spring_app.crud.model.repository.manager.Manager;
import crud_spring_app.crud.model.repository.manager.TransactionsManager;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;

@Repository("cocktailsRepository")
public class CocktailsRepository {

    public static void add(CocktailsEntity entity) {
        TransactionsManager.saveTransaction(entity);
    }

    public static CocktailsEntity find(CocktailsEntity entity) {
        Query query = Manager.getEm().createQuery("SELECT entity FROM CocktailsEntity entity WHERE name = ?1 OR id = ?2", CocktailsEntity.class);
        query.setParameter(1, entity.getName());
        query.setParameter(2, entity.getId());

        return (CocktailsEntity) query.getSingleResult();
    }

    public static void update(CocktailsEntity entity) {
        Manager.getEm().getTransaction().begin();
        Manager.getEm().persist(entity);
        Manager.getEm().getTransaction().commit();
    }

    public static void delete(CocktailsEntity entity) {
       TransactionsManager.delete(entity);
    }

    public static ArrayList<CocktailsEntity> findAll() {
        Query query = Manager.getEm().createQuery("SELECT entity FROM CocktailsEntity entity", CocktailsEntity.class);
        //query.setParameter(1, "id");
        ArrayList<CocktailsEntity> resultList = (ArrayList<CocktailsEntity>) query.getResultList();
        return resultList;
    }

}
