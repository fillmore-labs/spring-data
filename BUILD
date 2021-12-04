load("@rules_java//java:defs.bzl", "java_binary")

JVM_FLAGS = [
    "-Djava.util.logging.manager=org.apache.logging.log4j.jul.LogManager",
    "-XX:+CrashOnOutOfMemoryError",
]

java_binary(
    name = "spring-data",
    jvm_flags = JVM_FLAGS,
    main_class = "com.fillmore_labs.example.spring_data.main.Main",
    runtime_deps = [
        "//src/main/java/com/fillmore_labs/example/spring_data/main",
    ],
)

java_binary(
    name = "spring-data-rest",
    jvm_flags = JVM_FLAGS,
    main_class = "com.fillmore_labs.example.spring_data.main.Main",
    runtime_deps = [
        "//src/main/java/com/fillmore_labs/example/spring_data/main:main-rest",
    ],
)
