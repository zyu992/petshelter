package ca.mcgill.ecse321.petshelter;

import ca.mcgill.ecse321.petshelter.utils.TokenUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class  MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @RequestMapping
    public String greeting(){
        return "Welcome to the Backend of PetShelter Project. ";
    }

    @Bean
    public TokenUtil tokenUtil(){
        return new TokenUtil();
    }

    @Bean
    public OpenEntityManagerInViewFilter openEntityManagerInViewFilter(){
        return new OpenEntityManagerInViewFilter();
    }
}
