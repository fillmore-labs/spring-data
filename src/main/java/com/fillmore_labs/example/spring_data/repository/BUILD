load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "repository",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/fillmore_labs/example/spring_data/entity",
        "//toolchain:checker",
        "//toolchain:spring_context",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_querydsl_querydsl_jpa",
        "@maven//:org_springframework_data_spring_data_commons",
        "@maven//:org_springframework_data_spring_data_jpa",
        "@maven//:org_springframework_data_spring_data_rest_core",
    ],
)
