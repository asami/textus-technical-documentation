ThisBuild / organization := "org.goldenport"
ThisBuild / version := "0.1.0-SNAPSHOT"

lazy val root = (project in file(".")).settings(name := "textus-technical-documentation")

// SmartDox multilingual/multi-format build and Documentation CAR packaging
// are Phase 1 integration points. Product sources live under src/main.
