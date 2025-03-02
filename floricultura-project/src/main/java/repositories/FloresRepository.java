package repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import models.Flores;

import java.util.List;

public class FloresRepository {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("floricultura");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void save(Flores flores) {
        entityManager.getTransaction().begin();
        if (flores.getId() == 0) {
            entityManager.persist(flores);
        } else {
            entityManager.merge(flores);
        }
        entityManager.getTransaction().commit();
    }

    public void remove(Flores flores) {
        entityManager.getTransaction().begin();
        entityManager.remove(flores);
        entityManager.getTransaction().commit();
    }

    public Flores findById(int id) {
        return entityManager.find(Flores.class, id);
    }

    public List<Flores> findAll() {
        String jpql = "select f from Flores f";
        TypedQuery<Flores> typedQuery = entityManager.createQuery(jpql, Flores.class);
        return typedQuery.getResultList();
    }

    public List<Flores> findByName(String nome) {
        String jpql = "select f from Flores f where f.nome like :nome";
        TypedQuery<Flores> typedQuery = entityManager.createQuery(jpql, Flores.class);
        typedQuery.setParameter("nome", "%" + nome + "%");
        return typedQuery.getResultList();
    }
}
