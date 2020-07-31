ThisBuild / scalaVersion := "2.12.7"
ThisBuild / organization := "com.example"

val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
val playJson = "com.typesafe.play" %% "play-json" % "2.6.9"
val gigahorse = "com.eed4si9n" %% "gigahorse-okhttp" % "0.3.1"
 
lazy val hello = (project in file("."))
  .aggregate(helloCore)
  .dependsOn(helloCore)
  .settings(
    name := "Hello",
    libraryDependencies += scalaTest % Test, 
  )

lazy val helloCore = (project in file("core"))
  .settings(
    name := "Hello Core",
    libraryDependencies ++= Seq(gigahorse, playJson),
    libraryDependencies += scalaTest % Test,
  )
