package com.fillmore_labs.example.spring_data.repository;

import com.fillmore_labs.example.spring_data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository
    extends JpaRepository<Person, Long>, QuerydslPredicateExecutor<Person> {}
