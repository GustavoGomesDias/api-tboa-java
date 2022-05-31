package com.api.tboa.DAO.generic;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Repository
@Component
public abstract class GenericDAOImp<T extends Serializable> implements GenericDAO<T> {
    private Class<T> clazz;

    @PersistenceContext(unitName = "JPA_DEMO")
    EntityManager entityManager;

    public GenericDAOImp(Class<T> clazz) {
        this.clazz = clazz;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_DEMO");
        this.entityManager = factory.createEntityManager();
    }

    @Override
    @Transactional
    public T findOne(long id) {
        return this.entityManager.find(this.clazz, id);
    }

    @Override
    public List<T> findAll() {
        return this.entityManager.createQuery("from" + this.clazz.getName()).getResultList();
    }

    @Override
    @Transactional
    public void create(T entity) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(entity);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            throw e;
        }
    }

    @Override
    @Transactional
    public void update(T entity) {
        this.entityManager.merge(entity);
    }

    @Override
    @Transactional
    public void delete(long id) {
        this.entityManager.remove(this.findOne(id));
    }
}
