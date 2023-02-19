package com.course.spring.hibernate_one_to_many_bi;

import com.course.spring.hibernate_one_to_many_bi.entity.Department;
import com.course.spring.hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyBiTest1 {

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
//            Department dep = new Department("IT", 300, 1200);
//            Employee emp1 = new Employee("Artem", "Gatmash", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1000);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            session.save(dep);
//-----------------------------------------------------
//            Department department = session.get(Department.class, 1);
//            System.out.println(department);
//            System.out.println(department.getEmps());
//-----------------------------------------------------
//            Employee employee = session.get(Employee.class,1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//-----------------------------------------------------
            /**
             *@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
             *       CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "department")
             */
            Employee employee = session.get(Employee.class, 4);
            session.delete(employee);


            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
