package pl.gda.pg.eti.kask.javaee.jsf.view.converters;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.CourierService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Courier;

import javax.enterprise.context.Dependent;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Courier.class, managed = true)
@Dependent
public class CourierConverter extends AbstractEntityConverter<Courier>{
    public CourierConverter() {
        super(Courier::getId, CourierService::findCourier);
    }
}
