name := "scala-hamsters-test"

version := "1.0.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "io.github.scala-hamsters" %% "hamsters" % "1.0.2",
   "org.scalatest" %% "scalatest" % "2.2.6" % Test  
)

resolvers += Resolver.url("github repo for hamsters", url("http://scala-hamsters.github.io/hamsters/releases/"))(Resolver.ivyStylePatterns)

fork in Test := true

parallelExecution in Test := false

licenses +=("Apache-2.0", url("http://opensource.org/licenses/apache2.0.php"))

// enable scala code formatting //
import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform

// Scalariform settings
SbtScalariform.autoImport.scalariformPreferences := SbtScalariform.autoImport.scalariformPreferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 100)
  .setPreference(DoubleIndentClassDeclaration, true)
  .setPreference(RewriteArrowSymbols, true)

// enable updating file headers //
import de.heikoseeberger.sbtheader.license.Apache2_0

headers := Map(
  "scala" -> Apache2_0("2016", "Dennis Vriend"),
  "conf" -> Apache2_0("2016", "Dennis Vriend", "#")
)

enablePlugins(AutomateHeaderPlugin)