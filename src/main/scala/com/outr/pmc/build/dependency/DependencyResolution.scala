package com.outr.pmc.build.dependency

import com.outr.pmc.Task

trait DependencyResolution extends Task {
  def jarDependencies = JARDependencies
}
