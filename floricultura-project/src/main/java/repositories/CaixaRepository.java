package repositories;

import models.Caixa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CaixaRepository {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("floricultura");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void save(Caixa caixa) {
        entityManager.getTransaction().begin();
        entityManager.persist(caixa);
        entityManager.getTransaction().commit();
    }

    public void update(Caixa caixa) {
        entityManager.getTransaction().begin();
        entityManager.merge(caixa);
        entityManager.getTransaction().commit();
    }

    public void delete(int id) {
        Caixa caixa = findById(id);
        if (caixa != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(caixa);
            entityManager.getTransaction().commit();
        }
    }

    public Caixa findById(int id) {
        return entityManager.find(Caixa.class, id);
    }

    public List<Caixa> findAll() {
        String jpql = "SELECT c FROM Caixa c";
        TypedQuery<Caixa> query = entityManager.createQuery(jpql, Caixa.class);
        return query.getResultList();
    }
}
