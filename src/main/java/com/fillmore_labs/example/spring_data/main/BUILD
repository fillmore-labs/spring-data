load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "main",
    srcs = glob(["*.java"]),
    resources = ["//src/main/resources"],
    visibility = ["//visibility:public"],
    runtime_deps = [
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:com_fasterxml_jackson_dataformat_jackson_dataformat_yaml",
        "@maven//:com_google_flogger_flogger_log4j2_backend",
        "@maven//:com_h2database_h2",
        "@maven//:com_lmax_disruptor",
        "@maven//:org_apache_logging_log4j_log4j_jcl",
        "@maven//:org_apache_logging_log4j_log4j_jul",
        "@maven//:org_apache_logging_log4j_log4j_slf4j18_impl",
        "@maven//:org_glassfish_jakarta_el",
        "@maven//:org_hibernate_hibernate_core",
        "@maven//:org_hibernate_validator_hibernate_validator",
    ],
    deps = [
        "//src/main/java/com/fillmore_labs/example/spring_data/config",
        "//src/main/java/com/fillmore_labs/example/spring_data/entity",
        "//src/main/java/com/fillmore_labs/example/spring_data/repository",
        "//src/main/java/com/fillmore_labs/example/spring_data/runner",
        "//toolchain:checker",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:com_google_flogger_flogger",
        "@maven//:org_springframework_boot_spring_boot",
        "@maven//:org_springframework_boot_spring_boot_autoconfigure",
        "@maven//:org_springframework_data_spring_data_jpa",
        "@maven//:org_springframework_spring_context",
    ],
)

java_library(
    name = "main-rest",
    visibility = ["//visibility:public"],
    runtime_deps = [
        ":main",
        "@maven//:org_apache_logging_log4j_log4j_web",
        "@maven//:org_eclipse_jetty_jetty_webapp",
        "@maven//:org_springframework_data_spring_data_rest_hal_explorer",
    ],
)
