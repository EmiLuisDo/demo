package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Employee;
import org.example.entities.Product;
import org.example.entities.Student;
import org.example.entities.keys.StudentKey;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
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

        Employee e1 = new Employee();
        e1.setAddress("Siempre viva 123");
        e1.setName("Homero");
        em.persist(e1);

//        Product p1 = new Product();
//        p1.setCode("ABC");
//        p1.setNumber(10);
//        p1.setColor("Red");
//        em.persist(p1);
//
        StudentKey id1 = new StudentKey();
        id1.setCode("ABC");
        id1.setNumber(10);
//        Student st1 = new Student();
//        st1.setId(id1);
//        st1.setName("Emiliano");
//        em.persist(st1);
//
//        StudentKey id2 = new StudentKey();
//        id2.setCode("DEF");
//        id2.setNumber(20);
//        Student st2 = new Student();
//        st2.setId(id2);
//        st2.setName("Gonza");
//        em.persist(st2);

        Student es = em.find(Student.class, id1);
        System.out.println(es);
        em.getTransaction().commit();
    }
}