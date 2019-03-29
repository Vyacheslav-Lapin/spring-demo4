package lab.model;

import org.springframework.stereotype.Service;

@Service
public class ApuBar implements Bar {

  public Squishee sellDrink(Person person) {
    if (person.isBroke())
      throw new CustomerBrokenException();

    System.out.println("Here is your Squishee");
    return new Squishee("Usual Squishee");
  }
}
