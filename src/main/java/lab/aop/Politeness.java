package lab.aop;

import lab.model.Drink;
import lab.model.Person;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Politeness {

  @Pointcut("execution(lab.model.Drink sellDrink(lab.model.Person))")
  public void sellDrink() {
  }

  @Before("sellDrink() && args(person)")
  public void sayHello(Person person) {
    System.out.printf("Hello %s. How are you doing?\n", person.getName());
  }

  @AfterReturning(pointcut = "sellDrink()", returning = "drink", argNames = "drink")
  public void askOpinion(Drink drink) {
    System.out.printf("Is %s Good Enough?\n", drink.getName());
  }

  @AfterThrowing("sellDrink()")
  public void sayYouAreNotAllowed() {
    System.out.println("Hmmm...");
  }

  @After("sellDrink()")
  public void sayGoodBye() {
    System.out.println("Good Bye!");
  }

  @SneakyThrows
  @Around("sellDrink()")
  public Object sayPoliteWordsAndSell(ProceedingJoinPoint pjp) {
    System.out.println("Hi!");
    Object retVal = pjp.proceed();
    System.out.println("See you!");
    return retVal;
  }

}
