name := "Scala_lessons"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "4.8.3" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")