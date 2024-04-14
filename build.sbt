import scala.collection.immutable.Seq

ThisBuild / scalaVersion := "2.13.9"

ThisBuild / version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """CodegenAPP""",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test,

        "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.0" % Test,
        "com.vmunier" % "scalajs-scripts_2.13" % "1.3.0",
        "com.typesafe.play" % "play-slick_2.13" % "5.3.0",
        "com.typesafe.slick" % "slick-codegen_2.13" % "3.5.0",
        "org.webjars.npm" % "react" % "18.3.0-next-fecc288b7-20221025",
        "org.webjars.npm" % "react-dom" % "18.2.0",
        "org.webjars" % "babel" % "6.3.26-1",
        "org.webjars.npm" % "babel__cli" % "7.11.6",
        "org.webjars.npm" % "babel__core" % "7.21.3",
        "com.typesafe.play" % "play-json_2.13" % "2.10.4",
        "org.mindrot" % "jbcrypt" % "0.4",
        "org.postgresql" % "postgresql" % "42.7.3",
        "com.typesafe.slick" %% "slick-hikaricp" % "3.5.0",
        "com.microsoft.sqlserver" % "mssql-jdbc" % "12.7.0.jre11-preview",
        "net.sourceforge.jtds" % "jtds" % "1.3.1",
      "com.h2database" % "h2" % "2.2.224",
      "org.flywaydb" % "flyway-core" % "8.5.13",
      "mysql" % "mysql-connector-java" % "5.1.24"
    )
  )
