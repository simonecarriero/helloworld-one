import Dependencies._

// This an example of a simple project definition.
// It should build on both sbt 0.13.15 and sbt 1.0.0

val username = "user"
val password = "pass"

val creds = Credentials(
    "https://pkgsprodsu3weu.app.pkgs.visualstudio.com/",
    "pkgs.dev.azure.com",
    username,
    password)

lazy val root = (project in file("."))
  .settings(
    organization in ThisBuild := "com.example",
    scalaVersion in ThisBuild := "2.12.2",
    version      in ThisBuild := "0.1.0",
    name := "Hello",
    libraryDependencies += scalaTest % Test,
    publishTo in ThisBuild := {
        val location = "https://pkgs.dev.azure.com/foobar/_packaging/foobar/maven/v1/"
        if (isSnapshot.value)
            Some("snapshots" at location + "snapshot")
        else
            Some("releases"  at location + "releases")
    },
    credentials += creds,
    publishMavenStyle := true

  )
