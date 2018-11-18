package pl.gda.pg.eti.kask.javaee.jsf.view.courier;

import lombok.Getter;
import lombok.Setter;
import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.CourierService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Courier;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Department;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@RequestScoped
public class ListCouriers implements Serializable {

    @Inject
    private CourierService courierService;

    @Getter
    @Setter
    private Department department = null;

    private Collection<Courier> couriers;

    public Collection<Courier> getCouriers() {
        if (couriers == null) {
            if(department == null) {
                couriers = courierService.findAllCouriers();
            }else {
                couriers = courierService.findCouriersOfDepartment(department);
            }
        }
        return couriers;
    }

    public String removeCourier(Courier courier) {
        courierService.removeCourier(courier);
        return "list_couriers?faces-redirect=true";
    }
}