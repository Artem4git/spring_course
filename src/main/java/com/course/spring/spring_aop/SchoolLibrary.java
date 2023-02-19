package com.course.spring.spring_aop;

import org.springframework.stereotype.Component;

@Component("schoolLibraryBean")
public class SchoolLibrary extends AbstractLibrary {

    public void getBook() {
        System.out.println("Мы берем книгу из SchoolLibrary");
    }
}
