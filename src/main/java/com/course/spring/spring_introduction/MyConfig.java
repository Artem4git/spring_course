package com.course.spring.spring_introduction;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:myApp.properties")
//@ComponentScan("com.course.spring.introduction")
public class MyConfig {

    @Bean
    @Scope("singleton")
    public Pet catBean() {
//        System.out.println("!!!");
        return new Cat();
    }

    @Bean
    public Person personBean() {
        return new Person(catBean());
    }
}
