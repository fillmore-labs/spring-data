package com.fillmore_labs.example.spring_data.main;

import com.fillmore_labs.example.spring_data.entity.EntityMarker;
import com.fillmore_labs.example.spring_data.repository.RepositoryMarker;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = {EntityMarker.class})
@EnableJpaRepositories(basePackageClasses = {RepositoryMarker.class})
public class DatabaseConfiguration {}
