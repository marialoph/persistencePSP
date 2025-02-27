
plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.plugin.serialization)
}

group = "com.example"
version = "0.0.1"

application {
    mainClass = "io.ktor.server.netty.EngineMain"

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.host.common)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback.classic)
    implementation(libs.ktor.server.config.yaml)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)

    implementation("org.jetbrains.exposed:exposed-dao:0.41.1")
    implementation("org.mariadb.jdbc:mariadb-java-client:2.7.3")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.41.1")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")

    implementation("io.ktor:ktor-server-auth-jwt:3.0.3")  //JWT
    implementation("io.ktor:ktor-server-auth:3.0.3")      // Módulo de autenticación
    implementation("com.auth0:java-jwt:4.4.0")
}
