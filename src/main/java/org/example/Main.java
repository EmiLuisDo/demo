package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.example.entities.*;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        EntityManagerFactory emf = null;
        String puName = "pu-name";
        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "none"); // create - none - update

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // SELECT , UPDATE , DELETE ; no hay INSERT
// ------------------------------------------------------------
//        String jpql = "SELECT p FROM Product p";
//        TypedQuery<Product> query = em.createQuery(jpql, Product.class);

//        String jpql = "SELECT p FROM Product p WHERE p.price > 5";
//        TypedQuery<Product> query = em.createQuery(jpql, Product.class);

//        String jpql = "SELECT p FROM Product p WHE RE p.price > :price AND p.name LIKE :name";
//        TypedQuery<Product> query = em.createQuery(jpql, Product.class);
//        query.setParameter("price", 5);
//        query.setParameter("name", "%z%");

//        List<Product> productList = query.getResultList();
//        for (Product p : productList){
//            System.out.println(p);
//        }
// ------------------------------------------------------------

//        String jpql = "SELECT AVG(p.price) FROM Product p";
//        TypedQuery<Double> q = em.createQuery(jpql, Double.class);
//        Double avg = q.getSingleResult();
//        System.out.println(avg);
//        -------------------------------------------------------------

//        String jpql = "SELECT COUNT(p) FROM Product p";
//        TypedQuery<Long> q = em.createQuery(jpql, Long.class);
//        Long cnt = q.getSingleResult();
//        System.out.println(cnt);

        //---------------------------------------------------------------------
//        String jpql = "SELECT p.name, p.price FROM Product p";
//        TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
//        q.getResultList().forEach( objects -> {
//            System.out.println(objects[0] + " " + objects[1]);
//        });
//        -------------------------------------------------------------------

//        String jpql = """
//                SELECT p.name, AVG(p.price)
//                FROM Product p GROUP BY p.name
//                """;
//        TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
//        List<Object[]> rs = q.getResultList();
//        for(Object[] r : rs){
//            System.out.println(r[0] + " " + r[1]);
//        }
//        ----------------------------------------------
        String jpql = "SELECT p FROM Product p WHERE p.name LIKE 'Candy'";
        TypedQuery<Product> q = em.createQuery(jpql, Product.class);
        Optional<Product> p;
        try{
            p = Optional.of(q.getSingleResult());
        }catch (Exception e){
            p = Optional.empty();
        }
        if (p.isPresent()) {
            System.out.println(p);
        }
        else
            System.out.println("Naranja");

        em.getTransaction().commit();
    }

}