package com.fillmore_labs.example.spring_data.repository;

/**
 * Marker for Spring {@link org.springframework.context.annotation.Configuration @Configuration}.
 *
 * @see
 *     org.springframework.data.jpa.repository.config.EnableJpaRepositories#basePackageClasses() @EnableJpaRepositories.basePackageClasses()
 */
public final class RepositoryMarker {
  private RepositoryMarker() {}
}
