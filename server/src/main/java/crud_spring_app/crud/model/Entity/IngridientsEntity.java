package crud_spring_app.crud.model.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ingridients", schema = "public", catalog = "coctails")
public class IngridientsEntity implements IEntity {
    private long id;
    private String name;
    private boolean alcohol;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "alcohol", nullable = false)
    public boolean isAlcohol() {
        return alcohol;
    }

    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngridientsEntity that = (IngridientsEntity) o;
        return id == that.id &&
                alcohol == that.alcohol &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, alcohol);
    }
}
