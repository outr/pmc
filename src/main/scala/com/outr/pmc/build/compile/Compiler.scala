package com.outr.pmc.build.compile

import java.io.File

import com.outr.pmc.Task
import com.outr.pmc.build.JARDependencies

import scala.collection.mutable.ListBuffer

trait Compiler extends Task {
  def jarDependencies = JARDependencies
  def inputDirectories = CompilerInputDirectories
  def outputDirectory = CompilerOutputDirectory
}

object Compiler {
  def findInputFiles(directories: List[File]): List[File] = {
    val b = ListBuffer.empty[File]

    def processDirectory(dir: File): Unit = {
      dir.listFiles().foreach { f =>
        if (f.isDirectory) {
          processDirectory(f)
        } else if (f.getName.toLowerCase.endsWith(".scala")) {
          b += f
        }
      }
    }

    directories.foreach(processDirectory)
    b.toList
  }
}