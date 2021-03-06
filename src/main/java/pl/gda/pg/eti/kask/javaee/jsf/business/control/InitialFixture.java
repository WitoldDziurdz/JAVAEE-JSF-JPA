package pl.gda.pg.eti.kask.javaee.jsf.business.control;

import pl.gda.pg.eti.kask.javaee.jsf.business.entities.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static java.util.Arrays.asList;

@ApplicationScoped
public class InitialFixture {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
        Pack p1 = new Pack(
                "Gdansk wyspianskiego 9",
                TypeSize.LARGE,
                10.22,
                false );
        Pack p2 = new Pack(
                "Gdansk wyspianskiego 12",
                TypeSize.SMALL,
                5,
                true );
        Pack p3 = new Pack(
                "Gdansk wyspianskiego 22",
                TypeSize.MEDIUM,
                5,
                true );

        Department d1 = new Department( 12, "Warszawa",false);
        Department d2 = new Department(22, "Gdansk",true);

        Courier c1 = new Courier("Hubert", "Polak","570434267",22,asList(p1,p2), d1);
        Courier c2 = new Courier("Piotr", "Majewski","570434211",44,asList(p3), d2);
        Courier c3 = new Courier("Krystian", "Olejnik","570431267",15,asList(p1,p2),d1);
        Courier c4 = new Courier("Oskar", "Nawrocki","570434331",19,asList(p3),d2);

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
        em.persist(d1);
        em.persist(d2);
    }
}
