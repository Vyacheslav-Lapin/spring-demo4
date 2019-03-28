package lab.model;

import static lombok.AccessLevel.PRIVATE;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Data
//@Entity
@NoArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = PRIVATE)
@AllArgsConstructor
@RequiredArgsConstructor
public class UsualPerson implements Person {

  //  @Id
  @Exclude
  @ToString.Exclude
  Long id;

  @NonNull
  String name;

  //  @ManyToOne(fetch = FetchType.EAGER)
//  @JoinColumn(name = "country_id")
  @NonNull
  Country country;

  @NonNull
  int age;

  @NonNull
  float height;

  @NonNull
  boolean isProgrammer;

  @Singular
  @NonNull
  List<String> contacts;
}
