package com.outr.pmc.build.run

import com.outr.pmc.build.JARDependencies
import com.outr.pmc.build.compile.CompilerOutputDirectory
import com.outr.pmc.{Project, Task, TaskFailureException}

class Run(implicit val project: Project) extends Task {
  def outputDirectory = CompilerOutputDirectory
  def jarDependencies = JARDependencies
  def mainClass = MainClass
  def fork = Fork

  override protected def run(): Unit = {
    // TODO: support dynamic determination of mainClass if not defined
    mainClass.get match {
      case Some(mc) => {
        if (fork.get) {
          throw new TaskFailureException("Run.fork == true is not currently supported.")
        } else {
          throw new TaskFailureException("Run.fork == false is not currently supported.")
        }
      }
      case None => throw new TaskFailureException("Run.mainClass is undefined.")
    }
  }
}