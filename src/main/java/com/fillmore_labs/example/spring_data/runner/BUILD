load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "runner",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/com/fillmore_labs/example/spring_data/config",
        "//src/main/java/com/fillmore_labs/example/spring_data/entity",
        "//src/main/java/com/fillmore_labs/example/spring_data/repository",
        "//toolchain:checker",
        "//toolchain:spring_context",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_google_flogger_flogger",
        "@maven//:com_google_guava_guava",
        "@maven//:jakarta_annotation_jakarta_annotation_api",
        "@maven//:javax_inject_javax_inject",
        "@maven//:org_springframework_boot_spring_boot",
        "@maven//:org_springframework_boot_spring_boot_autoconfigure",
        "@maven//:org_springframework_spring_core",
    ],
)
