package com.course.spring.hibernate_one_to_one;

import com.course.spring.hibernate_one_to_one.entity.Detail;
import com.course.spring.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneBiTest1 {

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
//-----------------------------------------------------
//            Employee employee = new Employee("Nikolay", "Ivanov", "HR", 850);
//            Detail detail = new Detail("New_York","+19324543","nikolay@mail.ru");
//            employee.setEmpDetail(detail);
//            detail.setEmployee(employee);
//            session.save(detail);
//-----------------------------------------------------
//            Detail detail = session.get(Detail.class, 4);
//            System.out.println(detail.getEmployee());
//-----------------------------------------------------
//            Detail detail = session.get(Detail.class, 4);
//            session.delete(detail);
//-----------------------------------------------------

            Detail detail = session.get(Detail.class, 1);
            /**cascade = {CascadeType.PERSIST, CascadeType.REFRESH}*/
            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);
//-----------------------------------------------------

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
