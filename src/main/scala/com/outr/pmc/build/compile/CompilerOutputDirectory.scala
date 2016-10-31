package com.outr.pmc.build.compile

import java.io.File

import com.outr.pmc.TaskProperty

object CompilerOutputDirectory extends TaskProperty[File](new File("target"))