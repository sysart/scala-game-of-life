name := "gameoflife"

version := "0.0"

organization := "org.agilefinland.oulu"


libraryDependencies ++= Seq(
    "org.specs2" %% "specs2" % "1.8.2" % "test",
    "org.scalatest" %% "scalatest" % "1.7.1" % "test"
    )

resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                    "releases"  at "http://oss.sonatype.org/content/repositories/releases"
                    )
