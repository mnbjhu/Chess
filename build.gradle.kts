plugins {
    kotlin("multiplatform") version "1.7.0"
    kotlin("plugin.serialization") version "1.7.10"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

val koinVersion: String by project
val logbackVersion: String by project
val ktorVersion: String by project


repositories {
    mavenCentral()
    maven(url = "https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
    maven (url = "https://jitpack.io")
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js(LEGACY) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
    sourceSets {
        val commonMain by getting{
            dependencies{
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0-RC")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
<<<<<<< HEAD
                
                implementation("io.ktor:ktor-server-netty:2.0.1")
                implementation("io.ktor:ktor-server-html-builder-jvm:2.0.1")
=======
                implementation("com.github.mnbjhu:KotlinRedisGraph:0.3.0")

                // Koin for Ktor
                implementation("io.insert-koin:koin-ktor:$koinVersion")
                implementation("io.insert-koin:koin-logger-slf4j:$koinVersion")
                // Ktor
                implementation("io.ktor:ktor-server-netty:$ktorVersion")
                implementation("io.ktor:ktor-server-html-builder-jvm:$ktorVersion")
>>>>>>> master
                implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")
                implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
                // Logger
                implementation("ch.qos.logback:logback-classic:$logbackVersion")
            }
        }
        val jvmTest by getting
        val jsMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react:18.0.0-pre.332-kotlin-1.6.21")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:18.0.0-pre.332-kotlin-1.6.21")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion:11.9.0-pre.332-kotlin-1.6.21")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                // Koin Core features
                implementation("io.insert-koin:koin-core:$koinVersion")
// Koin Test features
            }
        }
        val jsTest by getting{
            dependencies{ implementation("io.insert-koin:koin-test:$koinVersion") }
        }
    }
}

application {
    mainClass.set("org.example.application.ServerKt")
}

tasks.named<Copy>("jvmProcessResources") {
    val jsBrowserDistribution = tasks.named("jsBrowserDistribution")
    from(jsBrowserDistribution)
}

tasks.named<JavaExec>("run") {
    dependsOn(tasks.named<Jar>("jvmJar"))
    classpath(tasks.named<Jar>("jvmJar"))
}