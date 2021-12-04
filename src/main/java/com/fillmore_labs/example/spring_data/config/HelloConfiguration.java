package com.fillmore_labs.example.spring_data.config;

import com.google.errorprone.annotations.Immutable;
import javax.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

@Immutable
@Validated
@ConfigurationProperties(prefix = "hello")
public final class HelloConfiguration {
  private final @NotNull String name;

  @ConstructorBinding
  public HelloConfiguration(String name) {
    this.name = name;
  }

  /**
   * The name.
   *
   * @return A name.
   */
  public String name() {
    return name;
  }
}
