package crud_spring_app.crud.controller;

import crud_spring_app.crud.model.Entity.IngridientsEntity;

public class General {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCocktailName() {
        return cocktailName;
    }

    public void setCocktailName(String cocktailName) {
        this.cocktailName = cocktailName;
    }

    public boolean isAlchohol() {
        return alchohol;
    }

    public void setAlchohol(boolean alchohol) {
        this.alchohol = alchohol;
    }

    public IngridientsEntity[] getIngridientsNames() {
        return ingridientsNames;
    }

    public void setIngridientsNames(IngridientsEntity[] ingridientsNames) {
        this.ingridientsNames = ingridientsNames;
    }

    private long id;
    private String cocktailName;
    private boolean alchohol;
    private IngridientsEntity[] ingridientsNames;


}
