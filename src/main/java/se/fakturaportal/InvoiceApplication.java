package se.fakturaportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by Linda on 2016-03-11.
 */
@SpringBootApplication
public class InvoiceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(InvoiceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(InvoiceApplication.class, args);
    }
}