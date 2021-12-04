package com.fillmore_labs.example.spring_data.classcheck;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.Resource;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

public final class ClassCheckTest {
  @Rule public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test
  public void testDuplicates() {
    var classGraph = new ClassGraph();
    try (var scan = classGraph.scan();
        var resourceList = scan.getAllResources().filter(ClassCheckTest::resourceFilter)) {
      for (var duplicate : resourceList.findDuplicatePaths()) {
        softly.fail("Duplicate resource: %s", duplicate.getKey());
        try (var duplicates = duplicate.getValue()) {
          for (var resource : duplicates) {
            softly.fail("-> %s", resource.getURI());
          }
        }
      }
    }
  }

  private static boolean resourceFilter(Resource resource) {
    // This is a hack
    var classpathElementURI = resource.getClasspathElementURI().toString();
    if (classpathElementURI.contains("java_tools/Runner_deploy.jar")
        || classpathElementURI.contains("java_tools/JacocoCoverage_jarjar_deploy.jar")) {
      return false;
    }
    var path = resource.getPath();
    if (path.equals("module-info.class")) {
      return false;
    }
    if (!path.endsWith(".class") || path.length() < 7) {
      return false;
    }
    // Check filename is not simply ".class"
    var c = path.charAt(path.length() - 7);
    return c != '/' && c != '.';
  }
}
