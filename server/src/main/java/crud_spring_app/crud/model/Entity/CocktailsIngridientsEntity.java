package crud_spring_app.crud.model.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "coctails_ingridients", schema = "public", catalog = "coctails")
public class CocktailsIngridientsEntity implements IEntity {

    private long id;
    private long coctailId;
    private long ingridientId;
    private Double quantity;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "coctail_id", nullable = false)
    public long getCoctailId() {
        return coctailId;
    }

    public void setCoctailId(long coctailId) {
        this.coctailId = coctailId;
    }

    @Basic
    @Column(name = "ingridient_id", nullable = false)
    public long getIngridientId() {
        return ingridientId;
    }

    public void setIngridientId(long ingridientId) {
        this.ingridientId = ingridientId;
    }

    @Basic
    @Column(name = "quantity", nullable = true, precision = 0)
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CocktailsIngridientsEntity that = (CocktailsIngridientsEntity) o;
        return id == that.id &&
                coctailId == that.coctailId &&
                ingridientId == that.ingridientId &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coctailId, ingridientId, quantity);
    }
}
