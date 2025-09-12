package org.example;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.dto.CountedEnrollmentForStudent;
import org.example.dto.EnrolledStudent;
import org.example.entities.*;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
//        ej 1
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<Customer> cq = builder.createQuery(Customer.class) ;
//        Root<Customer> customerRoot = cq.from(Customer.class);
//        cq.select(customerRoot);
//        TypedQuery<Customer> query = em.createQuery(cq);
//        query.getResultList().forEach(System.out::println);

        // ej 2
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<String> cq = builder.createQuery(String.class) ;
//        Root<Customer> customerRoot = cq.from(Customer.class);
//        cq.select(customerRoot.get("name"));
//        TypedQuery<String> query = em.createQuery(cq);
//        query.getResultList().forEach(System.out::println);

//        ej 3
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<Object[]> cq = builder.createQuery(Object[].class) ;
//        Root<Customer> customerRoot = cq.from(Customer.class);
//        cq.multiselect(customerRoot.get("name"), customerRoot.get("id"));
//        TypedQuery<Object[]> query = em.createQuery(cq);
//        query.getResultList().forEach( or -> System.out.println(or[0] + " " + or[1]));

//        ej 4
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<Object[]> cq = builder.createQuery(Object[].class) ;
//        Root<Customer> customerRoot = cq.from(Customer.class);
//        cq.multiselect(customerRoot.get("name"), customerRoot.get("id"))
//            .where(builder.ge(customerRoot.get("id"), 3), builder.lessThan(customerRoot.get("id"), 5))
//            .orderBy(builder.desc(customerRoot.get("id"))
//            );
//        TypedQuery<Object[]> query = em.createQuery(cq);
//        query.getResultList().forEach( or -> System.out.println(or[0] + " " + or[1]));


//        ej 5
//        CriteriaBuilder cbuilder = em.getCriteriaBuilder();
//        CriteriaQuery<Object[]> cq = cbuilder.createQuery(Object[].class);
//        Root<Customer> customerRoot = cq.from(Customer.class);
//        cq.multiselect(customerRoot.get("name"), cbuilder.sum(customerRoot.get("id")));
//
//        cq.where(cbuilder.ge(customerRoot.get("id"), 5));
//        cq.groupBy(customerRoot.get("name"));
//        TypedQuery<Object[]> query = em.createQuery(cq);


//        query.getResultList().forEach( or -> System.out.println(or[0] + " " + or[1]));

        em.getTransaction().commit();
    }

}