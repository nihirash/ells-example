package io.github.nihirash.cirno

import com.nihirash.ells.Interpreter
import io.github.nihirash.cirno.lisp.{CirnoEnv, CirnoEval}
import processing.core.PApplet

class CirnoUI(code: String) extends PApplet {
  val eval = new CirnoEval(this)
  val env = CirnoEnv.predef
  val interpreter = new Interpreter(eval, env)

  override def settings(): Unit = {
    interpreter.run(code, env)  match {
      case Left(er) => println(er)
      case _ =>
    }

    interpreter.run("(settings)", env) match {
      case Left(er) => println(er)
      case _ =>
    }
  }

  override def draw(): Unit = {
    interpreter.run("(draw)", env) match {
      case Left(er) => println(er)
      case _ =>
    }
  }

  override def keyPressed(): Unit =
    interpreter.run("(key-pressed)", env) match {
    case Left(er) => println(er)
    case _ =>
  }

}
