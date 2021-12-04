package com.fillmore_labs.example.spring_data.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.checkerframework.checker.nullness.qual.Nullable;

@Entity
@SuppressWarnings("allcheckers:type.anno.before.modifier")
public class Person {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Nullable
  private Long id;

  @Column(nullable = false)
  private String givenName;

  @Nullable private String surname;

  @OneToMany(cascade = ALL, mappedBy = "person", fetch = FetchType.EAGER)
  private List<EmailAddress> email;

  @SuppressWarnings("nullness:initialization.fields.uninitialized")
  protected Person() {}

  public Person(String givenName, @Nullable String surname) {
    this.givenName = givenName;
    this.surname = surname;
    this.email = new ArrayList<>();
  }

  public static Person of(String givenName, @Nullable String surname, String... email) {
    var person = new Person(givenName, surname);
    for (var e : email) {
      person.addEmail(new EmailAddress(person, e));
    }
    return person;
  }

  @Nullable
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public Optional<String> getSurname() {
    return Optional.ofNullable(surname);
  }

  public void setSurname(@Nullable String surname) {
    this.surname = surname;
  }

  public List<EmailAddress> getEmail() {
    return email;
  }

  public void setEmail(List<EmailAddress> email) {
    this.email = email;
  }

  public void addEmail(EmailAddress address) {
    email.add(address);
  }

  @Override
  public String toString() {
    return "Person{"
        + "id="
        + id
        + ", givenName='"
        + givenName
        + '\''
        + ", surname='"
        + surname
        + '\''
        + ", email="
        + email
        + '}';
  }

  // Default equals(Object) and hashCode()
}
