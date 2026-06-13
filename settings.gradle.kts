
pluginManagement {
    repositories {
        mavenLocal()
        val gpr_user: String? by settings
        val gpr_key: String? by settings
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/kodeinkoders/kodein-themes")
            content {
                @Suppress("UnstableApiUsage")
                includeGroupAndSubgroups("net.kodein.themes")
            }
            credentials {
                username = gpr_user ?: System.getenv("GITHUB_ACTOR")
                password = gpr_key ?: System.getenv("GITHUB_TOKEN")
                if (username == null || password == null) {
                    logger.warn("WARNING: No GitHub credentials defined.")
                    logger.warn("WARNING: Please add the gpr_user and gpr_key properties in your \$HOME/.gradle/gradle.properties.")
                    logger.warn("WARNING: Do NOT add these properties into the project gradle.properties file (it should go in your HOME gradle.properties).")
                    logger.warn("WARNING: The gpr_user and gpr_key properties must correspond to a Github Classic Personal Access Token.")
                    logger.warn("WARNING: see https://docs.github.com/en/packages/learn-github-packages/about-permissions-for-github-packages#about-scopes-and-permissions-for-package-registries.")
                }
            }
        }
        gradlePluginPortal()
    }
}

rootProject.name = "Kodein-Public-Documents"

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenLocal()
        val gpr_user: String? by settings
        val gpr_key: String? by settings
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/kodeinkoders/kodein-themes")
            content {
                @Suppress("UnstableApiUsage")
                includeGroupAndSubgroups("net.kodein.themes")
            }
            credentials {
                username = gpr_user ?: System.getenv("GITHUB_ACTOR")
                password = gpr_key ?: System.getenv("GITHUB_TOKEN")
            }
        }
        mavenCentral()
    }
}

include(
    ":CVs",
)