package pl.gda.pg.eti.kask.javaee.jsf.view.courier;

import lombok.Getter;
import lombok.Setter;
import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.CourierService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Courier;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Department;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Pack;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@ViewScoped
public class EditCourier implements Serializable {

    @Inject
    private CourierService courierService;

    @Getter
    @Setter
    private Courier courier = new Courier();

    public Collection<Pack> getAvailablePacks() {
        return courierService.findAllPacks();
    }

    public Collection<Department> getAvailableDepartments() {
        return courierService.findAllDepartments();
    }

    public String saveCourier() {
        courierService.saveCourier(courier);
        return "list_couriers?faces-redirect=true";
    }
}
