import sbt._
import Keys._
object ScalaVaadinBuild extends Build {

  override def projects = Seq(root, core, demo)

  lazy val root = Project(
    id = "scalavaadin",
    base = file("."),
    settings = standardSettings,
    aggregate = Seq(core, demo)
  )

  lazy val core = Project(
    id = "core",
    base = file("core"),
    settings = standardSettings ++ Seq(
      libraryDependencies ++= Seq(Dependency.vaadin, Dependency.scalatest))
  )


  lazy val demo = Project(
    id = "demo",
    base = file("demo"),
    dependencies = Seq(core),
    settings = standardSettings ++ Seq(libraryDependencies ++= Seq(Dependency.jetty)) ++ WebPlugin.webSettings
  )


  object Dependency {
    val vaadin = "com.vaadin" % "vaadin" % "6.6.0"
    val scalatest = "org.scalatest" % "scalatest_2.9.0" % "1.6.1" % "test"
    val jetty = "org.mortbay.jetty" % "jetty" % "6.1.22" % "jetty"
  }


  lazy val standardSettings = Defaults.defaultSettings ++ Seq(
    organization := "org.scalavaadin",
    version := "0.0.2",
    scalaVersion := "2.9.0-1",
    scalacOptions ++= Seq("-encoding", "UTF-8", "-deprecation", "-unchecked")

  )


}