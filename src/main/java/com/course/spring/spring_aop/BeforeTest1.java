package com.course.spring.spring_aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeforeTest1 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibraryBean", UniLibrary.class);
        Book book = context.getBean("book", Book.class);
        uniLibrary.getBook();
        uniLibrary.getMagazine();
        uniLibrary.addBook("Artem",book);
        uniLibrary.addMagazine();
//        uniLibrary.returnMagazine();

//        SchoolLibrary schoolLibrary = context.getBean("schoolLibraryBean", SchoolLibrary.class);
//        schoolLibrary.getBook();

        context.close();
    }
}
