package com.outr.pmc

class TaskFailureException(val message: String, cause: Option[Throwable] = None) extends RuntimeException(message, cause.orNull)