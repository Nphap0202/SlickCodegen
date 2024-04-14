package models

object CodeGen extends App {
  slick.codegen.SourceCodeGenerator.main(Array("slick.jdbc.SQLServerProfile",
    "com.microsoft.sqlserver.jdbc.SQLServerDriver",
    "jdbc:sqlserver://localhost:1433;applicationName=CodegenAPP;integratedSecurity=false;authenticationScheme=NativeAuthentication;databaseName=asexxa;encrypt=true;trustServerCertificate=true",
    "/users/PHAP NGUYEN/Desktop/Scala/CodegenAPP",
    "models",
    "sa",
    "sasa"))

  //Postgres database
  //  slick.codegen.SourceCodeGenerator.run(
  //    "slick.jdbc.PostgresProfile",
  //    "org.postgresql.Driver",
  //    "jdbc:postgresql://localhost:5435/tasklist?user=postgres&password=password",
  //    //"/D:/CodegenApp/",
  //    "/users/PHAP NGUYEN/Desktop/Scala/CodegenAPP",
  //    "models",
  //    None,
  //    None,
  //    true,
  //    false
  //  )
}
