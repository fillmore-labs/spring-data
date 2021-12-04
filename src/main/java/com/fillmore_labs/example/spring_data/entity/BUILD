load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "entity",
    srcs = glob(["*.java"]),
    javacopts = ["-AskipDefs=\\.Q[A-Z][A-Za-z0-9_]*$$"],
    visibility = ["//visibility:public"],
    deps = [
        "//toolchain:checker",
        "//toolchain:querydsl",
        "//toolchain:spring_context",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_google_guava_guava",
        "@maven//:jakarta_persistence_jakarta_persistence_api",
    ],
)
