package hu.test.dynamic.dynamictables;

import hu.test.dynamic.dynamictables.domain2.Event;
import hu.test.dynamic.dynamictables.domain.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Optional;

@Service
public class EventTypeService {

//    @Autowired
//    @Qualifier("myEntityManagerFactory")
//    private EntityManagerFactory emf;

    @Autowired
    EntityManagerFactoryUtil entityManagerFactoryUtil;

    private EntityManager em;

//    @PostConstruct
//    private void init() {
//        em = entityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
//    }

    EntityManager creaEntityManager() {
        return entityManagerFactoryUtil.getEntityManagerFactory().createEntityManager();
    }

    public void saveEventType(EventType eventType) {

        EntityManager em = creaEntityManager();
        em.getTransaction().begin();
        em.persist(eventType);
        em.getTransaction().commit();

        em.close();
    }

    public void saveEvent(Event event) {

//        entityManagerFactoryUtil.setEntityManagerFactory(Optional.of("hu.test.dynamic.dynamictables.domain2"));
//        EntityManager em = creaEntityManager();
//
//        em.getTransaction().begin();
//        em.persist(event);
//        em.getTransaction().commit();
//
//        em.close();

        entityManagerFactoryUtil.setEntityManagerFactory(Optional.of("hu.test.dynamic.dynamictables.domain"));
        em = creaEntityManager();

        EventType build = EventType.builder().name("myname").description("mydesc").build();
        JpaRepository<EventType, Serializable> repository = createJpaRepository(em);
//        em.getTransaction().begin();
//        em.persist();
//        em.getTransaction().commit();
        repository.save(build);
        em.close();

    }

    private JpaRepository createJpaRepository(EntityManager em) {
        try {
            return new SimpleJpaRepository<EventType, Serializable>(EventType.class, em);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
