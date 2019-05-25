package crud_spring_app.crud.model.services;

import crud_spring_app.crud.model.Entity.IngridientsEntity;
import crud_spring_app.crud.model.repository.IngridientsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ingridientsService")
public class IngridientsService {

    public static IngridientsEntity save(IngridientsEntity ingridientsEntity) {
        IngridientsRepository.add(ingridientsEntity);
        return ingridientsEntity;
    }
    public static IngridientsEntity find(String name) {
        IngridientsEntity entity = new IngridientsEntity();
        entity.setName(name);
        return IngridientsRepository.find(entity);
    }

    public static IngridientsEntity find(int id) {
        IngridientsEntity entity = new IngridientsEntity();
        entity.setId(id);
        return IngridientsRepository.find(entity);
    }

    public static IngridientsEntity change(IngridientsEntity ingridientsEntity) {
        IngridientsRepository.update(ingridientsEntity);
        return ingridientsEntity;
    }
    public static IngridientsEntity remove(String name) {
        IngridientsEntity entity = new IngridientsEntity();
        entity.setName(name);
        IngridientsRepository.delete(entity);
        return entity;
    }

    public static List<IngridientsEntity> findAll() {
        return IngridientsRepository.findAll();
    }
}
