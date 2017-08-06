package com.obm;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ObmWebApplication extends SpringBootServletInitializer implements CommandLineRunner {

    public static void main(String[] args){
        SpringApplication.run(ObmWebApplication.class,args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("spring boot Starting");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ObmWebApplication.class);
    }
}
