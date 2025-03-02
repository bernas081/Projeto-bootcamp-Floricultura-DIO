package repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import models.Cliente;

import java.util.List;

public class ClienteRepository {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("floricultura");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void save(Cliente cliente) {
        entityManager.getTransaction().begin();
        if (cliente.getId() == 0) {
            entityManager.persist(cliente);
        } else {
            entityManager.merge(cliente);
        }
        entityManager.getTransaction().commit();
    }

    public void remove(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();
    }

    public Cliente findById(int id) {
        return entityManager.find(Cliente.class, id);
    }

    public List<Cliente> findAll() {
        String jpql = "select c from Cliente c";
        TypedQuery<Cliente> typedQuery = entityManager.createQuery(jpql, Cliente.class);
        return typedQuery.getResultList();
    }
}