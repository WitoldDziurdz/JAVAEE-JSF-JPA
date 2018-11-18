package pl.gda.pg.eti.kask.javaee.jsf.view.converters;

import pl.gda.pg.eti.kask.javaee.jsf.business.boundary.CourierService;
import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Department;

import javax.enterprise.context.Dependent;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Department.class, managed = true)
@Dependent
public class DepartmentConverter extends  AbstractEntityConverter<Department> {
    public DepartmentConverter() {
        super(Department::getId, CourierService::findDepartment);
    }
}
