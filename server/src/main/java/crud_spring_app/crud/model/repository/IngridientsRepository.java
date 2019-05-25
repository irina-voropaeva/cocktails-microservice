package crud_spring_app.crud.model.repository;

import crud_spring_app.crud.model.Entity.IngridientsEntity;
import crud_spring_app.crud.model.repository.manager.Manager;
import crud_spring_app.crud.model.repository.manager.TransactionsManager;
import org.springframework.stereotype.Repository;


import javax.persistence.Query;
import java.util.ArrayList;

@Repository("ingridientsRepository")
public class IngridientsRepository {
    public static void add(IngridientsEntity entity) {
        TransactionsManager.saveTransaction(entity);
    }

    public static IngridientsEntity find(IngridientsEntity entity) {
        Query query = Manager.getEm().createQuery("SELECT entity FROM IngridientsEntity entity WHERE name = ?1 OR id = ?2", IngridientsEntity.class);
        query.setParameter(1, entity.getName());
        query.setParameter(2, entity.getId());

        return (IngridientsEntity) query.getSingleResult();
    }

    public static void update(IngridientsEntity entity) {
        TransactionsManager.saveTransaction(entity);
    }

    public static void delete(IngridientsEntity entity) {
        TransactionsManager.delete(entity);
    }

    public static ArrayList<IngridientsEntity> findAll() {
        Query query = Manager.getEm().createQuery("SELECT entity FROM IngridientsEntity entity", IngridientsEntity.class);
        ArrayList<IngridientsEntity> resultList = (ArrayList<IngridientsEntity>) query.getResultList();
        return resultList;
    }
}
