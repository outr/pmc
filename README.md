# pmc
============

[![Build Status](https://travis-ci.org/outr/pmc.svg?branch=master)](https://travis-ci.org/outr/pmc)
[![Stories in Ready](https://badge.waffle.io/outr/pmc.png?label=ready&title=Ready)](https://waffle.io/outr/pmc)
[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/outr/pmc)
[![Maven Central](https://img.shields.io/maven-central/v/com.outr/pmc_2.11.svg)](https://maven-badges.herokuapp.com/maven-central/com.outr/pmc_2.11)
[![Latest version](https://index.scala-lang.org/com.outr/pmc/pmc/latest.svg)](https://index.scala-lang.org/com.outr/pmc/pmc)

Project Management in Code - An incredibly straight-forward project management and build tool for Scala.

### Status

Very early development. Focused on common build functionality to provide a viable alternative to Maven, SBT, or Gradle.

### Why another build tool?

Having used SBT for years, Maven before that, and Ant before that it may seem hard to justify creating yet another build
tool when so many capable ones exist today. However, it is because of continued frustration with the options available
that has led to the decision to create a build tool that goes down a different path.

### What's wrong with SBT?

Of all the options available SBT is by far the best and most powerful, and for the basics it is fairly easy to set up
and use. However, the moment you need a customization that's not built-in or doesn't have a ready-available plugin things
start to get incredibly complicated very quickly. Unfortunately SBT is one of the most common complaints from non-Scala
developers of why they won't use Scala. Of course it's easy to reply that you can just use Maven or Gradle just like you
can with Java, but SBT is notoriously the "preferred" option and has the most plugins to accomplish very specific tasks.

### What about Gradle?

We're Scala developers. To use an inferior language like Groovy as your build tool is simply wrong. If there isn't a
Scala tool for building your project and you have to fall to Groovy as your solution then that is justification enough
for PMC!

### What about Maven?

Maven was and still is a very powerful build tool. However, pretty much everyone agrees that writing your build
configuration in XML is laborious at best and incredibly limiting at worst. It is incredibly difficult to write your
own extensions and simply isn't very flexible.

### How is PMC Different?

The longing desire from SBT has always been to be able to write your build scripts in Scala, but along the way things
have gotten more and more complicated. Now we are at a place where you only write SBT scripts using a Scala DSL that
is incredibly confusing and leads many developers to hair pulling and rage.

PMC is meant to focus back on a dream of simplicity (yes, we remember when the 'S' in SBT meant something else). We
intend to represent this tool first and foremost as a framework that can be easily extended as any Scala framework.
Secondly, the code should remain simplistic and focused on supporting Scala without having to read a book before you
can use it. Finally, we want to make it as easy as possible to integrate custom code into the builds either via plugins
or one-off tasks specific to your project.

### Why Project instead of Build?

Though our initial focus is on providing a Build tool functionality, there are features beyond that scope we want to
support as well. For example, in SBT creating a multi-project build often leaves you with a "root" project that never
needs to be built, only intended to aggregate the sub-projects. This would not necessarily be a Build project, but a
`Aggregate` to allow invocation of sub-projects.

### Features for 1.0

* [X] Basic Framework Structure
* [X] REPL Support
* [X] Dependency Resolution
* [X] Compilation Support
* [ ] Support `Configuration` to define Scala version and Plugin dependencies
* [ ] Command-Line Invocation without REPL
* [ ] Configurable Repositories
* [ ] Task "Depends On"
* [ ] Clean Support
* [ ] Publish Local Support
* [ ] Publish to Remote Support
* [ ] Publish to Sonatype Support (Plugin)
* [ ] Aggregate Project / Multi-Project Support
* [ ] Scala Native PMC command to launch
* [ ] Project Generator Support (With Plugin Support for Multiple Generators)