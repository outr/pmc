package com.outr.pmc

import java.lang.reflect.Modifier

import com.outr.pmc.repl.Interpreter
import com.outr.scribe.Logging

import scala.tools.nsc.interpreter.IMain

trait Project extends Logging {
  implicit def thisProject: Project = this

  private var tasksMap = Map.empty[String, Task]

  val tasks = Task {
    println("Available tasks:")
    tasksMap.keys.foreach(n => println(s"\t$n"))
  }

  def init(iMain: IMain): Unit = {
    val map = getClass.getDeclaredMethods.collect {
      case method if classOf[Task].isAssignableFrom(method.getReturnType)
                     && Modifier.isPublic(method.getModifiers)
                     && !method.getName.contains("$") => method.getName -> method.invoke(this).asInstanceOf[Task]
    }.toMap
    tasksMap = map

    tasksMap.foreach {
      case (name, task) => iMain.bind(name, task.getClass.getName, task)
    }
  }

  def main(args: Array[String]): Unit = {
    // TODO: support command-line args not starting REPL
    new Interpreter(this)
  }

  def error(t: Throwable): Unit = logger.error(t)
}
