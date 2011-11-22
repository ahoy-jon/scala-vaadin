import sbt._
import com.github.siasia._
import WebPlugin._
import Keys._




object ScalaVaadinBuild extends Build {
  resolvers += ScalaToolsReleases

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
      libraryDependencies ++= Seq(Dependency.vaadin, Dependency.scalatest, Dependency.log, Dependency.slf4j))
  )


  lazy val demo = Project(
    id = "demo",
    base = file("demo"),
    dependencies = Seq(core),
    settings = standardSettings ++ Seq(libraryDependencies ++= Seq(Dependency.jetty)) ++ webSettings
  )


  object Dependency {
    val vaadin = "com.vaadin" % "vaadin" % "6.6.0"
    val scalatest = "org.scalatest" % "scalatest_2.9.0" % "1.6.1" % "test"
    val jetty = "org.mortbay.jetty" % "jetty" % "6.1.22" % "container"
    val log  = "com.weiglewilczek.slf4s" %% "slf4s" % "1.0.7"
    val slf4j = "org.slf4j" % "slf4j-log4j12" % "1.6.1"% "test"
  }


  lazy val standardSettings = Defaults.defaultSettings ++ Seq(
    organization := "org.scalavaadin",
    version := "0.0.3",
    scalaVersion := "2.9.1",
    scalacOptions ++= Seq("-encoding", "UTF-8", "-deprecation", "-unchecked")

  )


}