plugins {
    alias(libs.plugins.kodein.themes.asciidoctor)
}

val pdfTheme = "light"
val htmlTheme = "light"

asciidoctor {
    listOf(
        "Salomon" to "BRYS",
//        "Romain" to "BOISSELLE",
    ).forEach { (firstName, lastName) ->
        directory(layout.projectDirectory.dir(firstName)) {
            pdf {
                customTheme(
                    baseTheme = pdfTheme,
                    themesDir = layout.projectDirectory.dir("themes/pdf"),
                    themeName = "cv-$pdfTheme",
                    resourceProject = rootProject,
                )
            }
            html {
                kodeinTheme(
                    theme = htmlTheme,
                    resourceProject = rootProject,
                )
            }
            backends.all {
                copyResources {
                    from(layout.projectDirectory.dir("icons")) {
                        into("icons")
                    }
                }
                backend {
                    attrs {
                        attribute("expert", "$firstName $lastName")
                    }
                }
            }
        }
    }
}
