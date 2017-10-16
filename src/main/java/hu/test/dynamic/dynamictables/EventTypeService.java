package hu.test.dynamic.dynamictables;

import hu.test.dynamic.dynamictables.domain.EventType;
import hu.test.dynamic.dynamictables.domain2.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;

@Service

//@org.springframework.transaction.annotation.Transactional
public class EventTypeService {

//    @Autowired
//    @Qualifier("myEntityManagerFactory")
//    private EntityManagerFactory emf;

    @Autowired
    EntityManagerFactoryUtil entityManagerFactoryUtil;

    @Autowired
    JpaTransactionManager jpaTransactionManager;

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

//    @Transactional(value = "jpaTransactionManager")
    public void saveEvent(Event event) {

//        entityManagerFactoryUtil.setEntityManagerFactory(Optional.of("hu.test.dynamic.dynamictables.domain"));
        em = creaEntityManager();
//        em.getDelegate().

        EventType build = EventType.builder().name("myname").description("mydesc").build();
        JpaRepository<EventType, String> repository = new SimpleJpaRepository<EventType, String>(EventType.class, em);
//        em.getTransaction().begin();

//        em.persist(build);

        repository.save(build);
//        em.getTransaction().commit();

//        CriteriaBuilder cb = em.getCriteriaBuilder();
//
//        CriteriaQuery<EventType> q = cb.createQuery(EventType.class);
//        Root<EventType> c = q.from(EventType.class);
//        q.select(c);
//
//        TypedQuery<EventType> query = em.createQuery(q);
//        List<EventType> results = query.getResultList();


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
