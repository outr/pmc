package com.outr.pmc.build.clean

import com.outr.pmc.build.compile.CompilerOutputDirectory
import com.outr.pmc.{Project, Task}
import org.powerscala.io._

class Clean(implicit val project: Project) extends Task {
  def outputDirectory = CompilerOutputDirectory

  override protected def run(): Unit = {
    outputDirectory.get.listFiles().foreach(IO.delete)
  }
}
