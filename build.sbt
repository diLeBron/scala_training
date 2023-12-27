name := "scala_training"

version := "0.1"

scalaVersion := "2.13.12"

val http4sVersion = "0.23.15"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "2.10.0",
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
//  "org.http4s" %% "http4s-blaze-client" % http4sVersion
)
