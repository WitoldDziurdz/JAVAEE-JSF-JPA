package pl.gda.pg.eti.kask.javaee.jsf.business.entities;

import lombok.*;
import pl.gda.pg.eti.kask.javaee.jsf.business.message.ErrorMessage;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;


@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = Pack.Queries.FIND_ALL, query = "select p from Pack p"),
        @NamedQuery(name = Pack.Queries.FIND_PACKS, query = "select p from Pack p where p.price > :price")
})
public class Pack implements Serializable {
    public static class Queries {
        public static final String FIND_ALL = "PACK_FIND_ALL";
        public static final String FIND_PACKS = "PACK_FIND_BY_PRICE";
    }

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = ErrorMessage.TEXT)
    private String address;

    @NotNull(message = ErrorMessage.NULL)
    private TypeSize typeSize;

    @NotNull(message = ErrorMessage.POSITIVE_NUMBER)
    @PositiveOrZero
    private Double price;

    @NotNull(message = ErrorMessage.NULL)
    private boolean express;

    @ManyToMany(mappedBy = "packs",cascade={MERGE, REFRESH, DETACH})
    private List<Courier> couriers = new ArrayList<>();



    public Pack( String address, TypeSize typeSize, double price, boolean express) {
        this.address = address;
        this.typeSize = typeSize;
        this.price = price;
        this.express = express;
    }

    @Override
    public String toString(){
        return  this.id + " " + this.address;
    }
}

