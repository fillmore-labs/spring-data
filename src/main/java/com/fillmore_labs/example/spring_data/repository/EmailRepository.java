package com.fillmore_labs.example.spring_data.repository;

import com.fillmore_labs.example.spring_data.entity.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmailRepository
    extends JpaRepository<EmailAddress, String>, QuerydslPredicateExecutor<EmailAddress> {}
