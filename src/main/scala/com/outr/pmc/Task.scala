package com.outr.pmc

import com.outr.pmc
import com.outr.scribe.Logging

trait Task extends (() => Unit) with Logging {
  val dependsOn = new TaskProperty[List[Task]](Nil)

  def project: pmc.Project

  final def apply(): Unit = {
    preRun()
    val success = try {
      run()
      true
    } catch {
      case t: Throwable => {
        project.error(t)
        false
      }
    }
    postRun(success)
  }

  protected def preRun(): Unit = {
    logger.info(s"Executing ${getClass.getSimpleName}...")
    invokeDependencies()
  }

  protected def postRun(success: Boolean): Unit = {
    if (success) {
      logger.info(s"${getClass.getSimpleName} completed successfully.")
    } else {
      logger.warn(s"${getClass.getSimpleName} completed with an error!")
    }
  }

  protected def run(): Unit

  protected def invokeDependencies(): Unit = dependsOn.get.foreach(_())

  override def toString(): String = getClass.getSimpleName
}

object Task {
  def apply(f: => Unit)(implicit project: pmc.Project): SimpleTask = new SimpleTask(project, () => f)
}