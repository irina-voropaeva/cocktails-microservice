package crud_spring_app.crud;

import crud_spring_app.crud.model.repository.manager.Manager;
import crud_spring_app.crud.model.repository.manager.TransactionsManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main( String[] args )
    {
        Manager manager = new Manager();
        TransactionsManager transactionsManager = new TransactionsManager();
    	SpringApplication.run(App.class, args);
    }
}
