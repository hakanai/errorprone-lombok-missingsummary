import net.ltgt.gradle.errorprone.CheckSeverity
import net.ltgt.gradle.errorprone.errorprone

plugins {
    java
    id("net.ltgt.errorprone") version "2.0.2"
    id("io.freefair.lombok") version "6.4.3"
}

group = "org.example"
version = "1.0-SNAPSHOT"

lombok {
    // Compile succeeds
    // version.set("1.18.16")
    // Breaks - generates invalid code which triggers an error instead
    // version.set("1.18.18")
    // Breaks - flags MissingSummary warning
    // version.set("1.18.20")
    // Breaks - flags MissingSummary warning
    // version.set("1.18.22")
    // Breaks - flags MissingSummary warning
    version.set("1.18.24")
}

dependencies {
    val errorproneVersion = "2.13.1"
    errorprone("com.google.errorprone:error_prone_core:$errorproneVersion")
    implementation("com.google.code.findbugs:jsr305:3.0.2")
}

tasks.withType<JavaCompile>().configureEach {
    options.errorprone {
        disableWarningsInGeneratedCode.set(true)
        check("MissingSummary", CheckSeverity.ERROR)
    }
}
