package com.spbgti.dispatcherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication//(scanBasePackages = { "com.spbgti.dispatcherapp.Application", "com.spbgti.dispatcherapp.Config", "com.spbgti.dispatcherapp.Repository"})
@ComponentScan(value = {"com.spbgti.dispatcherapp.Repository", "com.spbgti.dispatcherapp.Web", "com.spbgti.dispatcherapp.Service", "com.spbgti.dispatcherapp.Entity.Event.Command", "com.spbgti.dispatcherapp.Configuration"})//, "com.spbgti.dispatcherapp"})
public class Application {
    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }
}
