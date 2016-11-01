package com.outr.pmc.build.dependency

import com.outr.pmc.Task
import com.outr.pmc.build.JARDependencies

trait DependencyResolution extends Task {
  def jarDependencies = JARDependencies
}
