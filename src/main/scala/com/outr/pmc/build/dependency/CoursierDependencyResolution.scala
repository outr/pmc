package com.outr.pmc.build.dependency

import com.outr.pmc
import com.outr.pmc.TaskProperty
import com.outr.pmc.build.LibraryDependencies
import com.outr.pmc.build.compile.Compiler
import coursier._

import scalaz.concurrent.Task

class CoursierDependencyResolution(implicit val project: pmc.Project) extends DependencyResolution {
  def apply(): Unit = {
    val dependencies = LibraryDependencies.get.map(d => coursier.Dependency(coursier.Module(d.organization, d.name), d.version))
    val start = Resolution(dependencies)
    // TODO: support repositories
    val repositories = Seq(
      //      Cache.ivy2Local,
      //      Cache.ivy2Cache,
      MavenRepository("https://repo1.maven.org/maven2")
    )
    val fetch = Fetch.from(repositories, Cache.fetch())
    val resolution = start.process.run(fetch).unsafePerformSync
    val errors = resolution.errors
    //    val localArtifacts = Task.gatherUnordered(
    //      resolution.artifacts
    //    )
    val localArtifacts = Task.gatherUnordered(resolution.artifacts.map(Cache.file(_).run)).unsafePerformSync
    val localDependencies = localArtifacts.map(_.toEither).collect {
      case Right(f) => f
    }
    println(s"Errors: ${errors}")
    println(s"Artifacts: ${localArtifacts}")
    //    resolution.artifacts.foreach { a =>
    //      println(s"Artifact: ${a.url}")
    //    }
    jarDependencies := localDependencies
  }
}