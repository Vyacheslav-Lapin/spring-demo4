package ru.academy.springdemo4;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@WithMockUser(authorities = "ADMIN")
class SpringDemo4ApplicationTests {

  private static final MediaType HAL_JSON =
      MediaType.parseMediaType(
          "application/hal+json;charset=UTF-8");

  MockMvc mockMvc;

  CatRepository catRepository;

  @BeforeEach
  void setUp() {
    Stream.of("Murzik", "Barsik", "Vaska")
        .map(Cat::new)
        .forEach(catRepository::save);
  }

  @Test
  @SneakyThrows
  @DisplayName("Тестируем котов через рест!")
  void contextLoads() {
    mockMvc.perform(MockMvcRequestBuilders.get("/cats"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(HAL_JSON))
        .andExpect(mvcResult -> assertEquals("3",
            mvcResult.getResponse().getContentAsString()
                .split("totalElements")[1]
                .split(":")[1].trim()
                .split(",")[0]));
  }

}
