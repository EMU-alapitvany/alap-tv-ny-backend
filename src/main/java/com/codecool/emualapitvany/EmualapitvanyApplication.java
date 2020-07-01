package com.codecool.emualapitvany;

import com.codecool.emualapitvany.model.Patient;
import com.codecool.emualapitvany.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EmualapitvanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmualapitvanyApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
             User user = Patient.builder()
                    .username("userName")
                    .firstName("firstName")
                    .lastName("lastName")
                    .email("email")
                    .password("password")
                    .parentFirstName("parentFirstName")
                    .parentSecondName("parentSecondName")
                    .build();

            System.out.println(user);
        };
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())
          .build();
    }
}


