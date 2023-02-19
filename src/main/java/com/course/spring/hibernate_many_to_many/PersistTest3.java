package com.course.spring.hibernate_many_to_many;

import com.course.spring.hibernate_many_to_many.entity.Child;
import com.course.spring.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PersistTest3 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();

            Section section1 = new Section("Dance");
            Child child1 = new Child("Olya", 12);
            Child child2 = new Child("Grisha", 8);
            Child child3 = new Child("Pavel", 9);
            section1.addChildToSection(child1);
            section1.addChildToSection(child2);
            section1.addChildToSection(child3);

            session.beginTransaction();
            session.persist(section1);

            /*
            because of
                @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
             */

            session.getTransaction().commit();
            System.out.println("Done!!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
