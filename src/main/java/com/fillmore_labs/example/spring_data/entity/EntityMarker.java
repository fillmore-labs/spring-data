package com.fillmore_labs.example.spring_data.entity;

/**
 * Marker for Spring {@link org.springframework.context.annotation.Configuration @Configuration}.
 *
 * @see
 *     org.springframework.boot.autoconfigure.domain.EntityScan#basePackageClasses() @EntityScan.basePackageClasses()
 */
public final class EntityMarker {
  private EntityMarker() {}
}
