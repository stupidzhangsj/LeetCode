package com.stupidzhang.springbootlearn;

import com.stupidzhang.springbootlearn.transaction.DemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(basePackages = {"com.stupidzhang"})
@EnableTransactionManagement
@SpringBootApplication
public class SpringbootlearnApplication implements CommandLineRunner {
    @Autowired
    private DemonService demonService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootlearnApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        demonService.test1();
       // demonService.test1();
    }
}
