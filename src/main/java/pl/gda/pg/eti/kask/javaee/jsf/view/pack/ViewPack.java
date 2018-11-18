package pl.gda.pg.eti.kask.javaee.jsf.view.pack;

import lombok.Getter;
import lombok.Setter;

import pl.gda.pg.eti.kask.javaee.jsf.business.entities.Pack;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class ViewPack implements Serializable {

    @Getter
    @Setter
    private Pack pack;
}
