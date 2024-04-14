package models

object CodeGen extends App {
  //slick.codegen.SourceCodeGenerator.main(
  //  Array("slick.jdbc.SQLServerProfile",
  //    "slick.jdbc.SQLServerProfile$",
  //    "jdbc:sqlserver://localhost:1433;applicationName=play-scala-seed;integratedSecurity=true;authenticationScheme=NativeAuthentication;databaseName=tasklist",
  //    "app/models/scala/",
  //    "com.mypackage",
  //    "sa",
  //    "sasa")
  //)

  slick.codegen.SourceCodeGenerator.run(
    "slick.jdbc.PostgresProfile",
    "org.postgresql.Driver",
    "jdbc:postgresql://localhost:5435/tasklist?user=postgres&password=password",
    //"/D:/CodegenApp/",
    "/users/PHAP NGUYEN/Desktop/Scala/CodegenAPP",
    "models",
    None,
    None,
    true,
    false
  )
}
