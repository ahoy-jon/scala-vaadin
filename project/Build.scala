 import sbt._
 import Keys._
 import sbt.Package._
 import java.util.jar.Attributes.Name._


object ScalaVaadinBuild extends Build {
    val scala_vaadin = Project(
     id                  = "scala-vaadin",
     base                =  file("."),
     settings            = standardSettings,
     aggregate           = Seq(core, demo)
   )

    val core = Project(
     id       = "core",
     base     = file("core"),
     settings = standardSettings ++ Seq(
            libraryDependencies ++= Seq(Dependency.vaadin))
    )

   
    val demo = Project(
     id           = "demo",
     base         = file("demo"),
     dependencies = Seq(core),
     settings     = standardSettings ++ Seq(libraryDependencies += Dependency.jetty) ++ WebPlugin.webSettings
    )


object Dependency {
   val vaadin = "com.vaadin" % "vaadin" % "6.6.0"
   val jetty  = "org.mortbay.jetty" % "jetty" % "6.1.22" % "jetty"
}


   lazy val standardSettings = Defaults.defaultSettings ++ Seq(
     organization   := "org.scala-vaadin",
     version        := "0.0.1",
     scalaVersion   := "2.9.0-1",
     scalacOptions  ++= Seq("-encoding", "UTF-8", "-deprecation", "-unchecked")
    
   )



 }