import Dependencies._
name := "ells-example"
description := "Ells embedding example and processing to lisp bindings"

organization := "io.github.nihirash"
scalaVersion := "2.12.7"
version      := "0.1.0-SNAPSHOT"


libraryDependencies ++= Seq(Ells, Processing)
