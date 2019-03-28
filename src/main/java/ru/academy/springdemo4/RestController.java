package ru.academy.springdemo4;

import static lombok.AccessLevel.PRIVATE;

import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
@FieldDefaults(level = PRIVATE)
public class RestController {

  @GetMapping(path = "/api/dogs/{id}", params = "jhgdsf")
  public String m1(int id) {
    return "Sharik";
  }
}
