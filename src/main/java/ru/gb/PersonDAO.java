package ru.gb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonDAO {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("personPU");

    // Метод для добавления нового Person
    public void addPerson(Person person) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            em.persist(person);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Метод для обновления Person
    public void updatePerson(Person person) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            em.merge(person);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Метод для удаления Person
    public void deletePerson(Long personId) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            Person person = em.find(Person.class, personId);
            if (person != null) {
                em.remove(person);
            }
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Метод для получения Person по ID
    public Person getPerson(Long personId) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        try {
            return em.find(Person.class, personId);
        } finally {
            em.close();
        }
    }

    // Закрытие фабрики EntityManager
    public static void shutdown() {
        ENTITY_MANAGER_FACTORY.close();
    }
}
