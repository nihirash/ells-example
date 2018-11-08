import sbt._

object Versions {
  val EllsVersion = "0.2.4"
  val ProcessingVersion = "3.3.7"
}

object Dependencies {
  lazy val Ells = "io.github.nihirash" %% "ells" % Versions.EllsVersion
  lazy val Processing = "org.processing" % "core" % Versions.ProcessingVersion
}
