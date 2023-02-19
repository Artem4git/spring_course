package com.course.spring.spring_aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundTest3 {
    public static void main(String[] args) {
        System.out.println("method main starts");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibraryBean", UniLibrary.class);
        String bookName = uniLibrary.returnBook();
        System.out.println("В библиотеку вернули книку - " + bookName);

        context.close();
        System.out.println("method main ends");
    }
}
