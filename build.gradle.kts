plugins {
    kotlin("jvm") version "1.3.61"
    id("net.minecrell.plugin-yml.nukkit") version "0.3.0"
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

group = "tokyo.aieuo"
version = "1.0"

repositories {
    jcenter()
    maven(url = "https://repo.nukkitx.com/main/")
}


dependencies {
    shadow(kotlin("stdlib"))
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compileOnly("cn.nukkit:nukkit:1.0-SNAPSHOT")
    testCompileOnly("cn.nukkit:nukkit:1.0-SNAPSHOT")
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

nukkit {
    name = "Sliding"
    main = "tokyo.aieuo.sliding.Sliding"
    api = listOf("1.0.9")
    authors = listOf("aieuo")
    version = "0.1"
}