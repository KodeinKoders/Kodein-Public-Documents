plugins {
    alias(libs.plugins.kodein.resourceFiles)
}

dependencies {
    resourceFiles(libs.kodein.themes.asciidoctor.resources)
}

tasks.register<Copy>("asciidoctorDocuments") {
    dependsOn(subprojects.map { it.tasks.named("asciidoctorAll") })

    into(layout.buildDirectory.dir("documents"))

    subprojects.forEach { p ->
        into(p.name) {
            from(p.layout.buildDirectory.dir("asciidoctor"))
        }
    }
}