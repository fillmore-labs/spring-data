workspace(name = "com_fillmore_labs_spring_data")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# ---

http_archive(
    name = "rules_jvm_external",
    sha256 = "2cd77de091e5376afaf9cc391c15f093ebd0105192373b334f0a855d89092ad5",
    strip_prefix = "rules_jvm_external-4.2",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/4.2.tar.gz",
)

# ---

load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@rules_jvm_external//:specs.bzl", "maven")
load("//toolchain:defs.bzl", "testonly_artifacts")

maven_install(
    artifacts = [
        "com.fasterxml.jackson.core:jackson-databind:2.13.1",
        "com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.1",
        "com.google.errorprone:error_prone_annotations:2.10.0",
        "com.google.flogger:flogger-log4j2-backend:0.7.4",
        "com.google.flogger:flogger:0.7.4",
        "com.google.guava:guava:31.0.1-jre",
        "com.h2database:h2:2.1.210",
        "com.lmax:disruptor:3.4.4",
        "com.querydsl:querydsl-apt:5.0.0",
        "com.querydsl:querydsl-core:5.0.0",
        "com.querydsl:querydsl-jpa:5.0.0",
        "io.github.classgraph:classgraph:4.8.138",
        "jakarta.activation:jakarta.activation-api:1.2.2",
        "jakarta.annotation:jakarta.annotation-api:1.3.5",
        "jakarta.persistence:jakarta.persistence-api:2.2.3",
        "jakarta.transaction:jakarta.transaction-api:1.3.3",
        "jakarta.validation:jakarta.validation-api:2.0.2",
        "jakarta.xml.bind:jakarta.xml.bind-api:2.3.3",
        "org.apache.logging.log4j:log4j-api:2.17.1",
        "org.apache.logging.log4j:log4j-jcl:2.17.1",
        "org.apache.logging.log4j:log4j-jul:2.17.1",
        "org.apache.logging.log4j:log4j-slf4j18-impl:2.17.1",
        "org.apache.logging.log4j:log4j-web:2.17.1",
        "org.checkerframework:checker-qual:3.21.1",
        "org.checkerframework:checker:3.21.1",
        "org.glassfish:jakarta.el:3.0.4",
        "org.hibernate.validator:hibernate-validator:6.2.1.Final",
        "org.hibernate:hibernate-core:5.6.3.Final",
        "org.jetbrains:annotations:23.0.0",
        "org.ow2.asm:asm:9.2",
        "org.slf4j:slf4j-api:1.8.0-beta4",
        "org.springframework.boot:spring-boot-autoconfigure:2.6.2",
        "org.springframework.boot:spring-boot:2.6.2",
        "org.springframework.data:spring-data-jpa:2.6.1",
        "org.springframework.data:spring-data-rest-core:3.6.1",
        "org.springframework.data:spring-data-rest-hal-explorer:3.6.1",
        "org.springframework.data:spring-data-rest-webmvc:3.6.1",
        "org.springframework:spring-context-indexer:5.3.15",
        "org.springframework:spring-core:5.3.15",
        maven.artifact(
            artifact = "jetty-webapp",
            exclusions = ["org.slf4j:slf4j-api"],  # depends on 'org.slf4j:slf4j-api:2.0.0-alpha5'
            group = "org.eclipse.jetty",
            version = "10.0.7",
        ),
    ] + testonly_artifacts([
        "junit:junit:4.13.2",
        "org.assertj:assertj-core:3.22.0",
        "org.assertj:assertj-guava:3.4.0",
        "org.mockito:mockito-core:4.2.0",
        "org.springframework.boot:spring-boot-test-autoconfigure:2.6.2",
        "org.springframework.boot:spring-boot-test:2.6.2",
        "org.springframework:spring-test:5.3.15",
    ]),
    excluded_artifacts = [
        "org.springframework:spring-jcl",
    ],
    fetch_sources = True,
    maven_install_json = "//:maven_install.json",
    override_targets = {
        # Java EE is now Jakarta EE
        "javax.activation:javax.activation-api": ":jakarta_activation_jakarta_activation_api",
        "javax.persistence:javax.persistence-api": ":jakarta_persistence_jakarta_persistence_api",
        "javax.transaction:javax.transaction-api": ":jakarta_transaction_jakarta_transaction_api",
        "javax.xml.bind:jaxb-api": ":jakarta_xml_bind_jakarta_xml_bind_api",
        "org.jboss.spec.javax.transaction:jboss-transaction-api_1.2_spec": ":jakarta_transaction_jakarta_transaction_api",
    },
    repositories = [
        "https://repo1.maven.org/maven2",
        "https://repo.maven.apache.org/maven2",
    ],
)

load("@maven//:defs.bzl", "pinned_maven_install")

pinned_maven_install()

# ---
