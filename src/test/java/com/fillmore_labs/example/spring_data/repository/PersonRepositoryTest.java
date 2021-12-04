package com.fillmore_labs.example.spring_data.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.fillmore_labs.example.spring_data.entity.EmailAddress;
import com.fillmore_labs.example.spring_data.entity.Person;
import com.fillmore_labs.example.spring_data.entity.QPerson;
import com.fillmore_labs.example.spring_data.main.DatabaseConfiguration;
import com.querydsl.core.types.dsl.PathBuilder;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
@DataJpaTest
@ContextConfiguration(classes = {DatabaseConfiguration.class})
@RunWith(SpringRunner.class)
public class PersonRepositoryTest {
  @Autowired
  @SuppressWarnings("nullness:initialization.field.uninitialized")
  private PersonRepository people;

  @Test
  public void hasPeople() {
    assertThat(people.findAll()).hasSize(5);
  }

  @Test
  public void query() {
    var person = QPerson.person;
    var filter = person.email.any().address.endsWith(".darling@example.com");
    var order = person.givenName.asc();

    assertThat(people.findAll(filter, order))
        .hasSize(3)
        .extracting(Person::getGivenName)
        .isSorted();
  }

  @Test
  @SuppressWarnings("optional:methodref.receiver")
  public void queryDynamic() {
    var person = new PathBuilder<>(Person.class, "person");

    var filter =
        person
            .getList("email", EmailAddress.class)
            .any()
            .getString("address")
            .endsWith("@example.org");
    var order = person.getString("surname").asc();

    assertThat(people.findAll(filter, order))
        .hasSize(2)
        .extracting(Person::getSurname)
        .extracting(Optional::orElseThrow)
        .isSorted();
  }
}
