package com.outr.pmc

import com.outr.pmc

class SimpleTask(val project: pmc.Project, f: () => Unit) extends Task {
  override protected def run(): Unit = f()
}
