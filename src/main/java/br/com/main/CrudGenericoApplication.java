package br.com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"br.com.controller"})
public class CrudGenericoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudGenericoApplication.class, args);
    }

}
