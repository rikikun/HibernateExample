package com.hibernate.annotation.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


/**
 * User: assanai.manurat
 * Date: 4/10/2014
 * Time: 2:56 PM
 */
public class StudentEntityTest {


    @Before
    public void setup() throws Exception {



    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testInsertStudent() throws Exception {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        StudentEntity student = new StudentEntity("student1", "test@email.com");
        session.save(student);

        session.getTransaction().commit();

    }

    @Test
    public void testGetStudent() throws Exception {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        StudentEntity student  = (StudentEntity) session.get(StudentEntity.class, 1L);

        System.out.println("student : "+ student);

    }

    @Test
    public void testGetAllStudent() throws Exception {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        List<StudentEntity> studentEntityList = session.createCriteria(StudentEntity.class).list();

        System.out.println("Total of student : "+ studentEntityList);

    }
}
