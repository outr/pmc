package com.outr.pmc

import com.outr.pmc
import com.outr.scribe.Logging

trait Task extends (() => Unit) with Logging {
  val dependsOn = new TaskProperty[List[Task]](Nil)

  def name: String
  def project: pmc.Project

  project.register(this)

  def apply(): Unit

  protected def invokeDependencies(): Unit = dependsOn.get.foreach(_())

  override def toString(): String = s"task:$name"
}

object Task {
  def apply(name: String)(f: => Unit)(implicit project: pmc.Project): SimpleTask = new SimpleTask(name, project, () => f)
}