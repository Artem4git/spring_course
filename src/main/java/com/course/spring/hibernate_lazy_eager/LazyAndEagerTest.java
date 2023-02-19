package com.course.spring.hibernate_lazy_eager;

import com.course.spring.hibernate_lazy_eager.entity.Department;
import com.course.spring.hibernate_lazy_eager.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LazyAndEagerTest {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
//-----------------------------------------------------
//            Department dep = new Department("Sales", 800, 1500);
//            Employee emp1 = new Employee("Artem", "Gatmash", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1500);
//            Employee emp3 = new Employee("Anton", "Sidorov", 1200);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//            session.save(dep);
//-----------------------------------------------------
            //fetch = FetchType.EAGER vs LAZY
            System.out.println("Get department");
            Department department = session.get(Department.class, 4);
            System.out.println("show department");
            System.out.println(department);
            System.out.println("Подгрузим наших работников");
            department.getEmps().get(0);
            session.getTransaction().commit();
            System.out.println("show employees of the department");
            System.out.println(department.getEmps());

//            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
