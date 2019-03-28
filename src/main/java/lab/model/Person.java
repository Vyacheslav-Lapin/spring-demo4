package lab.model;

import java.util.List;

public interface Person {
  String getName();

  Long getId();

  Country getCountry();

  int getAge();

  float getHeight();

  boolean isProgrammer();

  List<String> getContacts();

  default void sayHello(Person person) {
    System.out.printf("Hello, %s, I'm %s!\n",
        person.getName(),
        getName());
  }
}
