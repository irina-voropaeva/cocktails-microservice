package crud_spring_app.crud.model.services;


import crud_spring_app.crud.model.Entity.IEntity;
import crud_spring_app.crud.model.repository.manager.Manager;
import org.springframework.stereotype.Service;

@Service("generalService")
public class GeneralService {

    /**
     * @param entity
     * @return void
     *  Save entity into the database
     */

    public static void persist(IEntity entity) {
        Manager.getEm().getTransaction().begin();
        Manager.getEm().persist(entity);
        Manager.getEm().getTransaction().commit();
        Manager.getEm().close();
    }
}
