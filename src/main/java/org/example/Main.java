package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.*;
import org.example.entities.keys.StudentKey;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        EntityManagerFactory emf = null;
        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "none"); // create - none - update

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), props);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User u1 = new User();
        u1.setName("User 1");

        User u2 = new User();
        u2.setName("User 2");

        Group g1 = new Group();
        g1.setName("Group 1");
        Group g2 = new Group();
        g2.setName("Group 2");

        g1.setUsers(List.of(u1, u2));
        g2.setUsers(List.of(u2));

        u1.setGroups(List.of(g1));
        u1.setGroups(List.of(g1, g2));

        em.persist(g1);
        em.persist(g2);

        em.getTransaction().commit();
    }
}