package com.outr.pmc

import com.outr.pmc.repl.Interpreter
import com.outr.scribe.Logging

import scala.tools.nsc.interpreter.IMain

trait Project extends Logging {
  implicit def thisProject: Project = this

  private var tasksMap = Map.empty[String, Task]

  private[pmc] def register[T <: Task](task: T): T = synchronized {
    assert(!tasksMap.contains(task.name), s"Cannot register multiple tasks with the same name (${task.name})! Already registered: ${tasksMap(task.name).getClass.getName}, Trying to register: ${task.getClass.getName}.")
    tasksMap += task.name -> task
    task
  }

  val tasks = Task("tasks") {
    println("Available tasks:")
    tasksMap.keys.foreach(n => println(s"\t$n"))
  }

  def init(iMain: IMain): Unit = {
    tasksMap.values.foreach { task =>
      iMain.bind(task.name, task.getClass.getName, task)
    }
  }

  def main(args: Array[String]): Unit = {
    // TODO: support command-line args not starting REPL
    new Interpreter(this)
  }
}
