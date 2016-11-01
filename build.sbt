name := "pmc"
organization := "com.outr"
version := "1.0.0"

scalaVersion := "2.11.8"
sbtVersion := "0.13.11"
fork := true
connectInput in run := true
mainClass in assembly := Some("example.ExampleProject")

libraryDependencies ++= Seq(
  "com.outr.scribe" %% "scribe-slf4j" % "1.2.5",
  "org.powerscala" %% "powerscala-io" % "2.0.2",
  "com.outr" %% "jefe-launch" % "1.0.0",
  "com.outr" %% "metarx" % "0.1.8-cyclical",
  "io.get-coursier" %% "coursier" % "1.0.0-M14-6",
  "io.get-coursier" %% "coursier-cache" % "1.0.0-M14-6",
  "org.scala-lang" % "scala-compiler" % "2.11.8"
)