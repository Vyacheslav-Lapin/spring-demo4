package ru.academy.springdemo4;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lab.model.Country;
import lab.model.Person;
import lab.model.UsualPerson;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@FieldDefaults(level = PRIVATE)
class HelloWorldTest {

  private static final String XML = "application-context.xml";

  Person expectedPerson = getExpectedPerson();

  BeanFactory context =
      new ClassPathXmlApplicationContext(XML);

  @Test
  void testInitPerson() {
    assertEquals(expectedPerson, context.getBean("person"));
  }

  private static Person getExpectedPerson() {
    return UsualPerson.builder()
               .age(35)
               .name("John Smith")
               .country(new Country()
                            .setId(1)
                            .setName("Russia")
                            .setCodeName("RU"))
               .contact("222-33-22")
               .contact("jhgsf@kjhsdf.ru")
               .contact("123476t234234")
               .height(1.72f)
               .isProgrammer(true)
               .build();
  }
}
