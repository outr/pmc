package example

import java.io.File

import com.outr.pmc.build.Build
import com.outr.pmc.build.dependency.Dependency

object ExampleProject extends Build {
  compiler.inputDirectories := List(new File("example"))
  libraryDependencies += Dependency("org.scala-lang", "scala-library", "2.11.8")
}