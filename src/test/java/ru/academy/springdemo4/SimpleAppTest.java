package ru.academy.springdemo4;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.academy.springdemo4.HelloWorldTest.getExpectedPerson;

import java.util.ArrayList;
import java.util.List;
import lab.model.Country;
import lab.model.Person;
import lab.model.UsualPerson;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@FieldDefaults(level = PRIVATE)
class SimpleAppTest {

  private static final String CONTEXT_XML = "application-context.xml";

  BeanFactory context = new ClassPathXmlApplicationContext(CONTEXT_XML);

  Person expectedPerson = getExpectedPerson();

  @Test
  void testInitPerson() {
    UsualPerson person = (UsualPerson) context.getBean("person");
//		FYI: Another way to achieve the bean
//		person = context.getBean(UsualPerson.class);
    assertEquals(expectedPerson, person);
  }
}
