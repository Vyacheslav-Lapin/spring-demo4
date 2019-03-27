package ru.academy.springdemo4;

import static lombok.AccessLevel.PRIVATE;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("WeakerAccess")
@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Cat {

  @Id
  @EqualsAndHashCode.Exclude
  @GeneratedValue
  Long id;

  @NonNull
  String name;

}
