package com.outr.pmc.build

import com.outr.pmc.Project
import com.outr.pmc.build.compile.{Compiler, ScalacCompiler}
import com.outr.pmc.build.dependency.{CoursierDependencyResolution, DependencyResolution}

trait Build extends Project {
  def libraryDependencies = LibraryDependencies

  // TODO: clean, publishLocal, publish
  val dependencyResolution: DependencyResolution = new CoursierDependencyResolution
  val compiler: Compiler = new ScalacCompiler
}