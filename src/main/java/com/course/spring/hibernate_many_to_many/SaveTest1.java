package com.course.spring.hibernate_many_to_many;

import com.course.spring.hibernate_many_to_many.entity.Child;
import com.course.spring.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveTest1 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();

            Section section = new Section("Football");
            Child child1 = new Child("Artem", 5);
            Child child2 = new Child("Masha", 7);
            Child child3 = new Child("Vasya", 6);
            section.addChildToSection(child1);
            section.addChildToSection(child2);
            section.addChildToSection(child3);
            session.beginTransaction();
            /*
                @ManyToMany(cascade = CascadeType.ALL)
             */
            session.save(section);

            session.getTransaction().commit();
            System.out.println("Done!!");
//*************************************************************
//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("VolleyBall");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Math");
//            Child child1 = new Child("Igor", 10);
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//            session.beginTransaction();
//
//            session.save(child1);
//
//            session.getTransaction().commit();
//            System.out.println("Done!!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
