package com.outr.pmc.build

import com.outr.pmc.TaskProperty
import com.outr.pmc.build.dependency.Dependency

object LibraryDependencies extends TaskProperty[Set[Dependency]](Set.empty) {
  def +=(dependency: Dependency): Unit = this := get + dependency
}