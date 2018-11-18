package pl.gda.pg.eti.kask.javaee.jsf.business.entities;

import lombok.*;
import pl.gda.pg.eti.kask.javaee.jsf.business.message.ErrorMessage;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REFRESH;

@Entity
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = Department.Queries.FIND_ALL, query = "select d from Department d")
})
public class Department implements Serializable {
    public static class Queries {
        public static final String FIND_ALL = "DEPARTMENT_FIND_ALL";
    }

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull(message = ErrorMessage.NULL)
    @PositiveOrZero(message = ErrorMessage.POSITIVE_NUMBER)
    private Integer numberOfWorkers;

    @NotBlank(message = ErrorMessage.TEXT)
    private String address;

    @NotNull(message = ErrorMessage.NULL)
    private boolean isStorage;

    @OneToMany(cascade = {ALL}, mappedBy = "department")
    private List<Courier> couriers;

    public Department( int numberOfWorkers, String address, boolean isStorage) {
        this.numberOfWorkers = numberOfWorkers;
        this.address = address;
        this.isStorage = isStorage;
    }
}

