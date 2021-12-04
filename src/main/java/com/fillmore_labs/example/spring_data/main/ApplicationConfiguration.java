package com.fillmore_labs.example.spring_data.main;

import com.fillmore_labs.example.spring_data.config.ConfigMarker;
import com.fillmore_labs.example.spring_data.runner.RunnerMarker;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackageClasses = {RunnerMarker.class})
@ConfigurationPropertiesScan(basePackageClasses = {ConfigMarker.class})
@Import({DatabaseConfiguration.class})
public class ApplicationConfiguration {}
