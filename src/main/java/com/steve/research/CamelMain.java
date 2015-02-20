package com.steve.research;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelMain {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/example-camel-context.xml");
        context.start();
        context.registerShutdownHook();
        Thread.currentThread().join();
    }
}
