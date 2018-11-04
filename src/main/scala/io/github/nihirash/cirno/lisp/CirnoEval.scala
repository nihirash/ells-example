package io.github.nihirash.cirno.lisp

import com.nihirash.ells.Eval
import com.nihirash.ells.lib.SpecialForm
import processing.core.PApplet

class CirnoEval(pApplet: PApplet) extends Eval {
  override val forms: Seq[SpecialForm] = baseForms :+ new CirnoForms(eval, pApplet)
}