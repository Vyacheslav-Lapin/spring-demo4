package ru.academy.springdemo4;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

import lab.model.ApuBar;
import lab.model.Bar;
import lab.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
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
class AopAspectJTest {

  Bar bar;

  Person person;

  @NonFinal
  String outPrintln;
  
  @BeforeEach
  void setUp() {
    outPrintln = TestUtils.fromSystemOutPrintln(
        () -> bar.sellDrink(person));
  }

  @Test
  void testBeforeAdvice() {
    assertTrue("Before advice is not good enought...",
        outPrintln.contains("Hello"));
    assertTrue("Before advice is not good enought...", outPrintln.contains("How are you doing?"));
    System.out.println(outPrintln);
  }

  @Test
  void testAfterAdvice() {
    System.out.println(outPrintln);
    assertTrue("After advice is not good enought...", outPrintln.contains("Good Bye!"));
  }

  @Test
  void testAfterReturningAdvice() {
    assertTrue("Customer is broken", outPrintln.contains("Good Enough?"));
    System.out.println(outPrintln);
  }

  @Test
  void testAroundAdvice() {
    assertTrue("Around advice is not good enought...", outPrintln.contains("Hi!"));
    assertTrue("Around advice is not good enought...", outPrintln.contains("See you!"));
    System.out.println(outPrintln);
  }

  @Test
  void testAllAdvices() {
    assertTrue("barObject instanceof ApuBar",
        bar instanceof ApuBar);
  }
}
