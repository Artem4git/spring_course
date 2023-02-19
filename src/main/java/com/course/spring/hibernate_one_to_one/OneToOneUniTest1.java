package com.course.spring.hibernate_one_to_one;

import com.course.spring.hibernate_one_to_one.entity.Detail;
import com.course.spring.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneUniTest1 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

//            Employee employee = new Employee("Garmash", "Artem", "IT", 500);
//            Detail detail = new Detail("Moscow","12934890","agmail@mail.ru");
//            employee.setEmpDetail(detail);
//-----------------------------------------------------
//            Employee employee = new Employee("Oleg", "Smirnov", "Sales", 700);
//            Detail detail = new Detail("Moscow","9081029388","olejka@mail.ru");
//            employee.setEmpDetail(detail);
//-----------------------------------------------------
//            Employee emp = session.get(Employee.class, 10);
//            System.out.println(emp.getEmpDetail());
//-----------------------------------------------------
            Employee emp = session.get(Employee.class, 2);
            session.delete(emp);
//-----------------------------------------------------
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
