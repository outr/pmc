package com.outr.pmc.build.run

import com.outr.jefe.launch.Launcher
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
        val launcher = new Launcher(mc, jarDependencies.get)
        val instance = if (fork.get) {
          logger.info(s"Running forked in ${outputDirectory.get.getAbsolutePath}...")
          launcher.process(outputDirectory.get)
        } else {
          throw new TaskFailureException("Run.fork == false is not currently supported.")
        }
        instance.start()
      }
      case None => throw new TaskFailureException("Run.mainClass is undefined.")
    }
  }
}