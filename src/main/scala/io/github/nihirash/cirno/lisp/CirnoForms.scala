package io.github.nihirash.cirno.lisp

import com.nihirash.ells.lib.SpecialForm
import com.nihirash.ells._
import processing.core.PApplet

class CirnoForms(val eval: (EllsType, Env) => EllsType, pApplet: PApplet) extends SpecialForm {
  import com.nihirash.ells.Implicits._

  override def call(id: EllsIdentifier, tail: List[EllsType], env: Env): Option[EllsType] =  {
    val args = tail.map(eval(_, env))
    Option(id.v match {
      case "size" => args.map(_.toNumber) match {
        case w :: h :: Nil =>
          pApplet.size(w.toLong.toInt, h.toLong.toInt)
          EllsNil()
        case _ => throw EllsArityException("Only 2 numeric arguments are acceptable")
      }
      case "mouse-x" => pApplet.mouseX
      case "mouse-y" => pApplet.mouseY
      case "mouse-button" => pApplet.mouseButton
      case "background" => args.map(_.toNumber) match {
        case color :: Nil =>
          pApplet.background(color.toLong.toInt)
          color
        case _ => throw EllsArityException("Only one numeric value acceptable")
      }
      case "rect" => args.map(_.toNumber) match {
        case x :: y :: w :: h :: Nil =>
          pApplet.rect(x.toDouble.toFloat, y.toDouble.toFloat, w.toDouble.toFloat, h.toDouble.toFloat)
          EllsNil()
        case _ => throw EllsArityException()
      }
      case "get-key" => if (pApplet.key != 0) pApplet.key.toString else EllsNil()
      case _ => null
    })
  }

}