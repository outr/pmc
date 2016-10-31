package com.outr.pmc.build.compile

import java.io.File

import com.outr.pmc
import com.outr.pmc.build.compile

import scala.tools.nsc.{Global, Settings}

class ScalacCompiler(implicit val project: pmc.Project) extends compile.Compiler {
  def exec(dependencies: => List[File] = jarDependencies.get,
            outputDirectory: => File = this.outputDirectory.get): Unit = {
    val s = new Settings()
    s.bootclasspath.append(dependencies.map(_.getAbsolutePath).mkString(":"))
    val out = outputDirectory
    out.mkdirs()
    s.outdir.value = out.getAbsolutePath
    val g = new Global(s)
    val run = new g.Run
    val sourceFiles = Compiler.findInputFiles(inputDirectories.get).map(_.getAbsolutePath)
    logger.info(s"Compiling ${sourceFiles.length} files (${sourceFiles.mkString(", ")}).")
    run.compile(sourceFiles)
  }

  override protected def run(): Unit = exec()
}