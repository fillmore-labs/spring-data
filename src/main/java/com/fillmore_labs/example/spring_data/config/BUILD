load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "config",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "//toolchain:checker",
        "//toolchain:spring_context",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_google_guava_guava",
        "@maven//:jakarta_validation_jakarta_validation_api",
        "@maven//:org_springframework_boot_spring_boot",
    ],
)
