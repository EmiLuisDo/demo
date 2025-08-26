package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.*;
import org.example.entities.keys.StudentKey;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.ArrayList;
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
        props.put("hibernate.hbm2ddl.auto", "create"); // create - none - update

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), props);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Post p1 = new Post();
        p1.setTitle("Post 1");
        p1.setContent("Post 1 cont");
        Comment c1 = new Comment();
        c1.setContent("Content comment");
        Comment c2 = new Comment();
        c2.setContent("Content comment 2");


        p1.setComments(List.of(c1, c2));
        c1.setPost(p1);
        c2.setPost(p1);

        em.persist(p1);

        em.getTransaction().commit();
    }
}