import sbt.Keys._

name := "graphEditor"

version := "1.0"



lazy val client = project.in(file("./src/main/scala/org/graphEditor/client"))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    resolvers += Resolver.sonatypeRepo("snapshots"),
    resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases",
    resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
      scalaVersion := "2.11.7",
      libraryDependencies ++= Seq(
          "org.scala-js" %%% "scalajs-dom" % "0.9.0"
        ),
    libraryDependencies += "org.scalactic" %% "scalactic" % "2.2.6",
      libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"
  )

lazy val storage = project.in(file("./src/main/scala/org/graphEditor/storage"))
    .settings(
      resolvers += Resolver.sonatypeRepo("snapshots"),
      resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases",
      resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
      resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/maven-releases/",
        scalaVersion := "2.11.7",
      libraryDependencies += "org.scalactic" %% "scalactic" % "2.2.6",
      libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test",
      libraryDependencies += "com.typesafe.slick" % "slick_2.11" % "3.1.1",
      libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.6.4"
    )

lazy val server = project.in(file("./src/main/scala/org/graphEditor/server"))
  .dependsOn(storage)
    .settings(
      resolvers += Resolver.sonatypeRepo("snapshots"),
      resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases",
      resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
      resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/maven-releases/",
        scalaVersion := "2.11.7",
      libraryDependencies += "org.scalactic" %% "scalactic" % "2.2.6",
      libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test",
      libraryDependencies += "com.typesafe.akka" % "akka-http-core_2.11" % "2.4.4",
      libraryDependencies += "com.typesafe.akka" % "akka-http-experimental_2.11" % "2.4.4",
      libraryDependencies += "com.typesafe.akka" % "akka-stream_2.11" % "2.4.4"
    )
