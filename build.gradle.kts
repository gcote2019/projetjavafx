plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.0.14"
}

group = "ca.qc.bdeb.sim203.projetjavafx"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

javafx {
    version = "20"
    modules = listOf("javafx.controls")
}

application {
    mainClass.set("ca.qc.bdeb.sim203.projetjavafx.Main")
}