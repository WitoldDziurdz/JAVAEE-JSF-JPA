package pl.gda.pg.eti.kask.javaee.jsf.business.entities;

import lombok.*;
import pl.gda.pg.eti.kask.javaee.jsf.business.message.ErrorMessage;
import pl.gda.pg.eti.kask.javaee.jsf.business.validators.PhoneAnnotate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.DETACH;

@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = Courier.Queries.FIND_ALL, query = "select c from Courier c")
})
public class Courier implements Serializable {
    public static class Queries {
        public static final String FIND_ALL = "COURIER_FIND_ALL";
    }

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = ErrorMessage.TEXT)
    private String name;

    @NotBlank(message = ErrorMessage.TEXT)
    private String surname;

    @NotBlank(message = ErrorMessage.PHONE)
    @PhoneAnnotate
    private String phone;

    @NotNull(message = ErrorMessage.AGE)
    private Integer age;

    @ManyToOne(cascade = {MERGE, REFRESH})
    Department department;

    @ManyToMany(cascade={MERGE, REFRESH, DETACH})
    private List<Pack> packs = new ArrayList<>();

    public Courier( String name, String surname, String phone, int age, List<Pack> packs, Department department) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.age = age;
        this.packs = packs;
        this.department = department;
    }

    @Override
    public String toString(){
        return  this.name + " " + this.surname;
    }
}