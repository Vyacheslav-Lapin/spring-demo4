package ru.academy.springdemo4;

import java.util.List;
import lab.model.Country;
import lab.model.Person;
import lab.model.UsualPerson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan("lab")
@EnableAspectJAutoProxy
//@ImportResource("classpath:application-context.xml")
public class SpringDemo4Application {

  public static void main(String[] args) {
    SpringApplication.run(SpringDemo4Application.class, args);
  }

  @Bean
  Person person(Country country,
                List<String> contacts) {

    return UsualPerson.builder()
               .age(35)
               .name("John Smith")
               .country(country)
               .contacts(contacts)
               .height(1.72f)
               .isProgrammer(true)
               .build();
  }

  @Bean
  List<String> contacts() {
    return List.of(
        "222-33-22",
        "jhgsf@kjhsdf.ru",
        "123476t234234"
    );
//    return new ArrayList(){{
//      add("222-33-22");
//      add("jhgsf@kjhsdf.ru");
//      add("123476t234234");
//    }};
  }

}

