package crud_spring_app.crud.model.repository.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("cocktails");
    private static EntityManager em = emf.createEntityManager();

    public void close() {
        Manager.getEmf().close();
    }

    public static EntityManager getEm() {
        return em;
    }

    public static void setEm(EntityManager em) {
        Manager.em = em;
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static void setEmf(EntityManagerFactory emf) {
        Manager.emf = emf;
    }
}
