pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "b"
include(":app")
include(":bweek03a")
include(":bweek03b")
include(":bweek04a")
include(":bweek04b")
include(":bweek05a")
include(":bweek05b")
include(":assignment2")
include(":bweek07a")
