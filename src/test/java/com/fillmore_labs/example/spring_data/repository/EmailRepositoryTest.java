package com.fillmore_labs.example.spring_data.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.fillmore_labs.example.spring_data.main.DatabaseConfiguration;
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
public class EmailRepositoryTest {
  @Autowired
  @SuppressWarnings("nullness:initialization.field.uninitialized")
  private EmailRepository emails;

  @Test
  public void hasEmailAddresses() {
    assertThat(emails.findAll()).hasSize(6);
  }
}
