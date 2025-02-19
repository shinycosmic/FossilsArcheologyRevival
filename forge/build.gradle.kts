@file:Suppress("UnstableApiUsage")

plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

architectury {
    platformSetupLoomIde()
    forge()
}

val common: Configuration by configurations.creating
val shadowCommon: Configuration by configurations.creating

configurations {
    compileClasspath.get().extendsFrom(common)
    runtimeClasspath.get().extendsFrom(common)
    named("developmentForge").get().extendsFrom(common)
}

val minecraftVersion: String by rootProject
val forgeVersion: String by rootProject
val architecturyVersion: String by rootProject
val archivesBaseName: String by rootProject
val parchmentDate: String by rootProject
val reiVersion: String by rootProject
val terraBlenderVersion: String by rootProject

dependencies {
    "mappings"(loom.layered {
        officialMojangMappings()
        parchment("org.parchmentmc.data:parchment-1.18.2:$parchmentDate@zip")
    })

    forge("net.minecraftforge:forge:${forgeVersion}")
    // Remove the next line if you don't want to depend on the API
    modApi("dev.architectury:architectury-forge:${architecturyVersion}")

    common(project(path = ":common", configuration = "namedElements")) { isTransitive = false }
    shadowCommon(project(path = ":common", configuration = "transformProductionForge")) { isTransitive = false }

    modImplementation("me.shedaniel:RoughlyEnoughItems-forge:${reiVersion}")
    modImplementation("software.bernie.geckolib:geckolib-forge-1.18:3.0.57")
    modImplementation("com.github.glitchfiend:TerraBlender-forge:${minecraftVersion}-${terraBlenderVersion}")
}

loom {
    accessWidenerPath.set(project(":common").loom.accessWidenerPath)

    forge {
        convertAccessWideners.set(true)
        extraAccessWideners.add(loom.accessWidenerPath.get().asFile.name)
        mixinConfig("fossil.mixins.json")

        //dataGen { //breaks my forge run, so I disable it when not needed
        //    mod(archivesBaseName)
        //}
        /*
        mixinConfig("fa-common.mixins.json")
        mixinConfig("fa-forge.mixins.json")

        let's use these when we actually need it
        */
    }
}

tasks {
    processResources {
        inputs.property("version", project.version)
        //duplicatesStrategy = DuplicatesStrategy.INCLUDE
        filesMatching("META-INF/mods.toml") {
            expand("version" to project.version)
        }

        from(project(":common").sourceSets.main.get().resources)
    }

    shadowJar {
        exclude("fabric.mod.json")

        configurations = listOf(project.configurations["shadowCommon"])
        archiveClassifier.set("forge-dev-shadow")
        archiveBaseName.set(archivesBaseName)
    }

    remapJar {
        inputFile.set(shadowJar.get().archiveFile)
        dependsOn(shadowJar)
        archiveClassifier.set("forge")
        archiveBaseName.set(archivesBaseName)
    }

    jar {
        archiveClassifier.set("dev")
    }
}

val javaComponent = components["java"] as AdhocComponentWithVariants
javaComponent.withVariantsFromConfiguration(configurations["shadowRuntimeElements"]) {
    skip()
}

publishing {
    publications {
        create<MavenPublication>("mavenForge") {
            artifactId = archivesBaseName + "-" + project.name
            from(components["java"])
        }
    }

    // See https://docs.gradle.org/current/userguide/publishing_maven.html for information on how to set up publishing.
    repositories {
        // Add repositories to publish to here.
    }
}