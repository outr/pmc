package com.outr.pmc

import com.outr.pmc

trait Task extends (() => Unit) {
  def name: String
  def project: pmc.Project

  project.register(this)

  def apply(): Unit

  override def toString(): String = s"task:$name"
}

object Task {
  def apply(name: String)(f: => Unit)(implicit project: pmc.Project): SimpleTask = new SimpleTask(name, project, () => f)
}