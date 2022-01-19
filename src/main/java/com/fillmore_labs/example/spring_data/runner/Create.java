package com.fillmore_labs.example.spring_data.runner;

import com.fillmore_labs.example.spring_data.entity.Person;
import com.fillmore_labs.example.spring_data.repository.PersonRepository;
import com.google.common.flogger.FluentLogger;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;

@Named
@Priority(20)
public final class Create implements CommandLineRunner {
  private static final FluentLogger logger = FluentLogger.forEnclosingClass();

  private final PersonRepository people;

  @Inject
  /* package */ Create(PersonRepository people) {
    this.people = people;
  }

  @Override
  public void run(String... args) {
    var person = Person.of("La", "Le", "lu@example.com", "li@example.com");
    try {
      var created = people.save(person);
      logger.atInfo().log("Created: %s", created);
    } catch (DataAccessException ex) {
      logger.atWarning().withCause(ex).log("Creation failed");
    }
  }
}
