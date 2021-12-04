load("@rules_java//java:defs.bzl", "java_library", "java_test")

java_library(
    name = "tests",
    testonly = True,
    srcs = glob(["*.java"]),
    javacopts = [
        "-Xlint:-classfile",
    ],
    resources = ["//src/test/resources"],
    deps = [
        "//src/main/java/com/fillmore_labs/example/spring_data/entity",
        "//src/main/java/com/fillmore_labs/example/spring_data/main",
        "//src/main/java/com/fillmore_labs/example/spring_data/repository",
        "//toolchain:assertj",
        "//toolchain:checker",
        "@maven//:com_querydsl_querydsl_core",
        "@maven//:org_springframework_boot_spring_boot_test",
        "@maven//:org_springframework_boot_spring_boot_test_autoconfigure",
        "@maven//:org_springframework_data_spring_data_jpa",
        "@maven//:org_springframework_spring_beans",
        "@maven//:org_springframework_spring_test",
    ],
)

java_test(
    name = "EmailRepositoryTest",
    size = "medium",
    runtime_deps = [":tests"],
)

java_test(
    name = "PersonRepositoryTest",
    size = "medium",
    runtime_deps = [":tests"],
)
