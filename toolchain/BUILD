load("@bazel_tools//tools/jdk:default_java_toolchain.bzl", "default_java_toolchain")
load("@rules_java//java:defs.bzl", "java_library", "java_package_configuration", "java_plugin")

default_java_toolchain(
    name = "toolchain_java11",
    package_configuration = [
        ":src_package_configuration",
        ":external_package_configuration",
    ],
    source_version = "11",
    target_version = "11",
    visibility = ["//visibility:public"],
    xlint = [
        "all",
        "-processing",
    ],
)

JAVACOPTS = [
    "-Werror",
    "-Xpkginfo:always",
    # Checker Framework
    "-ArequirePrefixInWarningSuppressions",
    "-AwarnUnneededSuppressions",
    "-AshowSuppressWarningsStrings",
    # Error Prone
    "-XepExcludedPaths:.*/_javac/.*",
    "-XepDisableWarningsInGeneratedCode",
    "-XepAllDisabledChecksAsWarnings",
    "-Xep:Java7ApiChecker:OFF",
    "-Xep:AndroidJdkLibsChecker:OFF",
    "-Xep:StaticOrDefaultInterfaceMethod:OFF",
    "-Xep:NoFunctionalReturnType:OFF",
    "-Xep:WildcardImport:OFF",
]

java_package_configuration(
    name = "src_package_configuration",
    javacopts = JAVACOPTS,
    packages = [":src_package_group"],
)

package_group(
    name = "src_package_group",
    packages = [
        "//src/...",
    ],
)

java_package_configuration(
    name = "external_package_configuration",
    javacopts = [
        "-Xlint:none",
    ],
    packages = [":external_package_group"],
)

package_group(
    name = "external_package_group",
    packages = [
        "-//src/...",
        "//...",
    ],
)

# ---
# https://checkerframework.org/manual/#nullness-checker
# https://checkerframework.org/manual/#optional-checker

java_plugin(
    name = "nullness_checker",
    processor_class = "org.checkerframework.checker.nullness.NullnessChecker",
    deps = ["@maven//:org_checkerframework_checker"],
)

java_plugin(
    name = "optional_checker",
    processor_class = "org.checkerframework.checker.optional.OptionalChecker",
    deps = ["@maven//:org_checkerframework_checker"],
)

java_library(
    name = "checker",
    exported_plugins = [
        "nullness_checker",
        "optional_checker",
    ],
    neverlink = True,
    visibility = ["//visibility:public"],
    exports = ["@maven//:org_checkerframework_checker_qual"],
)

# ---
# https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-scanning-index

java_plugin(
    name = "spring_context_processor",
    processor_class = "org.springframework.context.index.processor.CandidateComponentsIndexer",
    deps = ["@maven//:org_springframework_spring_context_indexer"],
)

java_library(
    name = "spring_context",
    exported_plugins = ["spring_context_processor"],
    visibility = ["//visibility:public"],
    exports = ["@maven//:org_springframework_spring_context"],
)

# ---
# http://www.querydsl.com

java_plugin(
    name = "querydsl_processor",
    generates_api = True,
    processor_class = "com.querydsl.apt.jpa.JPAAnnotationProcessor",
    deps = [
        "@maven//:com_querydsl_querydsl_apt",
        "@maven//:jakarta_annotation_jakarta_annotation_api",
        "@maven//:jakarta_persistence_jakarta_persistence_api",
    ],
)

java_library(
    name = "querydsl",
    exported_plugins = ["querydsl_processor"],
    visibility = ["//visibility:public"],
    exports = [
        "@maven//:com_querydsl_querydsl_core",
        "@maven//:jakarta_annotation_jakarta_annotation_api",
        "@maven//:org_jetbrains_annotations",
    ],
)

# ---
# https://assertj.github.io/doc/

java_library(
    name = "assertj",
    testonly = True,
    visibility = ["//visibility:public"],
    exports = [
        "@maven//:junit_junit",
        "@maven//:org_assertj_assertj_core",
        "@maven//:org_assertj_assertj_guava",
    ],
)

# ---
