name := "scala_training"

version := "0.1"

scalaVersion := "2.13.12"

val http4sVersion = "0.23.15"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "2.10.0",
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  //  "org.http4s" %% "http4s-blaze-client" % http4sVersion
  "org.scala-exercises" %% "exercise-compiler" % "0.7.1",
  "org.scala-exercises" %% "definitions" % "0.7.1",
  "com.chuusai" %% "shapeless" % "2.3.10",
  "org.scalatest" %% "scalatest" % "3.2.10",
  "org.scalacheck" %% "scalacheck" % "1.17.0",
  "org.scalatestplus" %% "scalacheck-1-14" % "3.2.2.0",
  "com.github.alexarchambault" %% "scalacheck-shapeless_1.15" % "1.3.0"
)
