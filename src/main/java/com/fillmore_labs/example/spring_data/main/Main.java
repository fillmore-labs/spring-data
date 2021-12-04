package com.fillmore_labs.example.spring_data.main;

import com.google.common.flogger.FluentLogger;
import org.springframework.boot.builder.SpringApplicationBuilder;

public final class Main {
  private static final FluentLogger logger = FluentLogger.forEnclosingClass();

  private Main() {}

  public static void main(String... args) {
    var ctx = new SpringApplicationBuilder(ApplicationConfiguration.class).run(args);
    if (ctx.isActive()) {
      logger.atInfo().log("Startup complete");
    }
  }
}
