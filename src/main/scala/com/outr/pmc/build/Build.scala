package com.outr.pmc.build

import com.outr.pmc.Project
import com.outr.pmc.build.clean.Clean
import com.outr.pmc.build.compile.{Compiler, ScalacCompiler}
import com.outr.pmc.build.dependency.{CoursierDependencyResolution, DependencyResolution}
import com.outr.pmc.build.run.Run

trait Build extends Project {
  def libraryDependencies = LibraryDependencies

  // TODO: publishLocal, publish
  val clean: Clean = new Clean
  val resolveDependencies: DependencyResolution = new CoursierDependencyResolution
  val compile: Compiler = new ScalacCompiler
  val run: Run = new Run

  // Configure default dependencies
  compile.dependsOn := List(resolveDependencies)
  run.dependsOn := List(compile)
}