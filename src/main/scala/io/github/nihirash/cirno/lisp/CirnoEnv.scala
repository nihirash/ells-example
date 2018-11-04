package io.github.nihirash.cirno.lisp

import com.nihirash.ells.Env

object CirnoEnv {
  val predef = Env.fromResource("predef.lisp", Env.preDef)
}
