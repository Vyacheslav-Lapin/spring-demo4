package ru.academy.springdemo4;

import static lombok.AccessLevel.PRIVATE;

import lab.model.Bar;
import lab.model.CustomerBrokenException;
import lab.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import ru.academy.springdemo4.commons.TestUtils;

@SpringBootTest
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@ContextConfiguration(classes = SpringDemo4Application.class)
class AopAspectJExceptionTest {

  Bar bar;

  Person person;

  @BeforeEach
  void setUp() {
    person.setBroke(true);
  }

  @Test
//(expected = CustomerBrokenException.class)
  void testAfterThrowingAdvice() {

    Assertions.assertThrows(CustomerBrokenException.class,
        () -> {
          TestUtils.fromSystemOutPrintln(
              () -> bar.sellDrink(person));
//          assertTrue("Customer is not broken",
//              AopLog.getStringValue().contains("Hmmm..."));
        });
  }
}
