package com.fillmore_labs.example.spring_data.entity;

import com.google.common.base.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.checkerframework.checker.nullness.qual.Nullable;

@Entity
public class EmailAddress {
  @ManyToOne(optional = false)
  @JoinColumn(name = "PERSON_ID", nullable = false)
  private Person person;

  @Column(unique = true, nullable = false)
  @Id
  private String address;

  @SuppressWarnings("nullness:initialization.fields.uninitialized")
  protected EmailAddress() {}

  public EmailAddress(Person person, String address) {
    this.person = person;
    this.address = address;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "EmailAddress{" + "person.id=" + person.getId() + ", address='" + address + '\'' + '}';
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof EmailAddress)) {
      return false;
    }
    var that = (EmailAddress) o;
    // Assumes that address is the unique id
    return Objects.equal(address, that.address);
  }

  @Override
  public int hashCode() {
    return address.hashCode();
  }
}
