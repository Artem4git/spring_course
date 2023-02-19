package com.course.spring.hibernate_many_to_many;

import com.course.spring.hibernate_many_to_many.entity.Child;
import com.course.spring.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetTest1 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();

            session.beginTransaction();

//            Section section = session.get(Section.class,1);
            Child child = session.get(Child.class, 4);
            System.out.println(child);
            System.out.println(child.getSections());

            session.getTransaction().commit();
            System.out.println("Done!!");
//****************************************************************

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Section section = session.get(Section.class,1);
//            session.delete(section);
//
//            session.getTransaction().commit();
//            System.out.println("Done!!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
