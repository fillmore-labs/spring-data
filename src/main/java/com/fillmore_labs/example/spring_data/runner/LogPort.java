package com.fillmore_labs.example.spring_data.runner;

import com.google.common.flogger.FluentLogger;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.server.LocalServerPort;

@Named
@ConditionalOnWebApplication
public final class LogPort implements CommandLineRunner {
  private static final FluentLogger logger = FluentLogger.forEnclosingClass();
  private final int port;

  @Inject
  /* package */ LogPort(@LocalServerPort int port) {
    this.port = port;
  }

  @Override
  public void run(String... args) {
    logger.atInfo().log("Open Spring Data REST HAL Explorer at http://127.0.0.1:%d/", port);
    logger.atInfo().log(
        "Open the H2 console at http://127.0.0.1:%d/h2-console, JDBC URL: `jdbc:h2:mem:testdb`",
        port);
  }
}
