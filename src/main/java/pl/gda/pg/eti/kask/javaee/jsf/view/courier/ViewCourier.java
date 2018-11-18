package pl.gda.pg.eti.kask.javaee.jsf.view.courier;

import lombok.Getter;
import lombok.Setter;

import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Courier;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class ViewCourier implements Serializable {

    @Getter
    @Setter
    private Courier courier;
}
