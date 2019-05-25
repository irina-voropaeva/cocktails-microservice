package crud_spring_app.crud.model.repository.manager;

import crud_spring_app.crud.model.Entity.IEntity;

public class TransactionsManager {

    public static void saveTransaction(IEntity entity) {
        Manager.getEm().getTransaction().begin();
        Manager.getEm().persist(entity);
        Manager.getEm().getTransaction().commit();
    }

    public static void delete(IEntity entity) {
        Manager.getEm().getTransaction().begin();
        Manager.getEm().remove(entity);
        Manager.getEm().getTransaction().commit();
    }

}
