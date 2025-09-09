package org.example;

import jakarta.persistence.*;
import org.example.dto.CountedEnrollmentForStudent;
import org.example.dto.EnrolledStudent;
import org.example.entities.*;
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
        String puName = "pu-name";
        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "none"); // create - none - update

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//        String courseJql = "SELECT c FROM Course c";
//        TypedQuery<Course> cq = em.createQuery(courseJql, Course.class);
//        cq.getResultList().forEach(System.out::println);
//
//        String studentJql = "SELECT s FROM Student s";
//        TypedQuery<Student> sq = em.createQuery(studentJql, Student.class);
//        sq.getResultList().forEach(System.out::println);
//
//        String enrollmentJql = "SELECT e FROM Enrollment e";
//        TypedQuery<Enrollment> eq = em.createQuery(enrollmentJql, Enrollment.class);
//        eq.getResultList().forEach(System.out::println);

//        String jpql = """
//                SELECT s, e FROM Student s INNER JOIN s.enrollments e
//                """;

//        String jpql = """
//                SELECT s, e FROM Student s JOIN s.enrollments e
//                """;

//        String jpql = """
//                SELECT s, e FROM Student s, Enrollment e WHERE e.student.id = s.id
//                """;
//        String jpql = """
//                SELECT s, e FROM Student s, Enrollment e WHERE e.student = s
//                """;

//        String jpql = """
//                SELECT s, e FROM Student s LEFT JOIN s.enrollments e
//                """;
//        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
//        List<Object[]> results = query.getResultList();
//        for(Object[] r: results){
//            System.out.println(r[0]);
//            System.out.println(r[1]);
//        }
        // para probar lazy loading:
//        System.out.println(((Enrollment) results.get(0)[1]).getCourse());

//        String jpql = """
//                SELECT NEW org.example.dto.EnrolledStudent(s, e) FROM Student s LEFT JOIN s.enrollments e
//                """;
//        TypedQuery<EnrolledStudent> q = em.createQuery(jpql, EnrolledStudent.class);
//        q.getResultList().forEach(o -> System.out.println(o.student() + " " + o.enrollment()));

//        String jpql = """
//                SELECT s FROM Student s WHERE
//                    ( SELECT COUNT(e) FROM Enrollment e WHERE e.student.id = s.id ) > 1
//                """;
//        TypedQuery<Student> q = em.createQuery(jpql, Student.class );
//        q.getResultList().forEach(System.out::println);

//        String jpql = """
//                SELECT
//                    ( SELECT COUNT(e) FROM Enrollment e WHERE e.student.id = s.id )
//                    FROM Student s
//                """;
//        TypedQuery<Long> q = em.createQuery(jpql, Long.class );
//        q.getResultList().forEach(System.out::println);

//        String jpql = """
//                SELECT NEW org.example.dto.CountedEnrollmentForStudent(
//                    s,
//                    ( SELECT COUNT(e) FROM Enrollment e WHERE e.student.id = s.id )
//                )
//                FROM Student s
//                """;

//        String jpql = """
//                SELECT NEW org.example.dto.CountedEnrollmentForStudent(
//                    s.name,
//                    COUNT(s)
//                )
//                FROM Student s
//                GROUP BY s.name
//                """;

//        String jpql = """
//                SELECT NEW org.example.dto.CountedEnrollmentForStudent(
//                    s.name,
//                    COUNT(s)
//                )
//                FROM Student s
//                GROUP BY s.name
//                HAVING s.name LIKE '%e%'
//                ORDER BY s.name
//                """;
//        TypedQuery<CountedEnrollmentForStudent> q = em.createQuery(jpql, CountedEnrollmentForStudent.class );

//        TypedQuery<Student> q = em.createNamedQuery("getAllEnrolledStudents", Student.class);
//        q.getResultList().forEach(System.out::println);


//        String sql = """
//                SELECT * FROM student
//                """;
//        Query q = em.createNativeQuery(sql, Student.class);
//        q.getResultList().forEach(System.out::println);

//        String jpql2 = "SELECT ds FROM DistinctStudent ds";
//        TypedQuery<DistinctStudent> q2 = em.createQuery(jpql2, DistinctStudent.class);
//        q2.getResultList().forEach(System.out::println);

        StoredProcedureQuery spq = em.createStoredProcedureQuery("GetStudents", Student.class)
                .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                .setParameter("id", 2);

        spq.getResultList().forEach(System.out::println);

        em.getTransaction().commit();
    }

}