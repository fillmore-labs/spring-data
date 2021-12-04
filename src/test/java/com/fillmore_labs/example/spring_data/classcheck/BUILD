load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "tests",
    testonly = True,
    srcs = glob(["*.java"]),
    runtime_deps = [
        "//src/main/java/com/fillmore_labs/example/spring_data/main:main-rest",
    ],
    deps = [
        "//toolchain:assertj",
        "//toolchain:checker",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_google_flogger_flogger",
        "@maven//:io_github_classgraph_classgraph",
    ],
)

java_test(
    name = "ClassCheckTest",
    size = "medium",
    runtime_deps = [":tests"],
)
