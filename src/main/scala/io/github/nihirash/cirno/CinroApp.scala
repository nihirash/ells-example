package io.github.nihirash.cirno

import processing.core.PApplet

object CinroApp extends App {
  val program = scala.io.Source.fromFile("game.lisp").mkString
  val ui = new CirnoUI(program)
  PApplet.runSketch(Seq("CirnoUI").toArray, ui)
}
