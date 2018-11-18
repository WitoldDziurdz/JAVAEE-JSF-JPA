package pl.gda.pg.eti.kask.javaee.jsf.view.converters;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.CourierService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Pack;

import javax.enterprise.context.Dependent;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Pack.class, managed = true)
@Dependent
public class PackConverter extends AbstractEntityConverter<Pack> {
    public PackConverter() {
        super(Pack::getId, CourierService::findPack);
    }
}
