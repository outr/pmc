name := "pmc"
organization := "com.outr"
version := "1.0.0"

scalaVersion := "2.11.8"
sbtVersion := "0.13.11"
fork := true
connectInput in run := true
mainClass in assembly := Some("example.ExampleProject")

libraryDependencies ++= Seq(
  "com.outr" %% "metarx" % "0.1.8-cyclical",
  "io.get-coursier" %% "coursier" % "1.0.0-M14-6",
  "io.get-coursier" %% "coursier-cache" % "1.0.0-M14-6",
  "org.scala-lang" % "scala-compiler" % "2.11.8"
)