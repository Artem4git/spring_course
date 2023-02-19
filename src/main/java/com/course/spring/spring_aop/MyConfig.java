package com.course.spring.spring_aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.course.spring.spring_aop")
@EnableAspectJAutoProxy
public class MyConfig {
}
