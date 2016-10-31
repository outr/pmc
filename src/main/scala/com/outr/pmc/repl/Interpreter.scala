package com.outr.pmc.repl

import com.outr.pmc.Project

import scala.tools.nsc.Settings
import scala.tools.nsc.interpreter.ILoop

class Interpreter(project: Project) {
  val repl = new ILoop {
    override def prompt: String = "pmc> "

    override def createInterpreter(): Unit = {
      super.createInterpreter()

      intp.beQuietDuring {
        project.init(intp)
      }
    }
  }
  repl.process(new Settings {
    usejavacp.value = true
    deprecation.value = true
  })
}
