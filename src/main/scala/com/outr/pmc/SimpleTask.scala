package com.outr.pmc

import com.outr.pmc

class SimpleTask(val name: String, val project: pmc.Project, f: () => Unit) extends Task {
  def apply(): Unit = f()
}
