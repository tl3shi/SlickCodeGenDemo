name := "SlickCodeGen"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.typesafe.slick" % "slick_2.11" % "2.1.0",
  "com.typesafe.slick" % "slick-codegen_2.11" % "2.1.0",
  "org.slf4j" % "slf4j-simple" % "1.7.7",
  "mysql" % "mysql-connector-java" % "5.1.36"
)

libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
