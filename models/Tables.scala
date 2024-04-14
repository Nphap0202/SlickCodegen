package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends Tables {
  val profile: slick.jdbc.JdbcProfile = slick.jdbc.SQLServerProfile
}

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for
  // tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Loginuser.schema

  /** Entity class storing rows of table Loginuser
   *  @param id Database column id SqlType(int identity), AutoInc, PrimaryKey
   *  @param username Database column username SqlType(varchar), Length(50,true)
   *  @param password Database column password SqlType(varchar), Length(200,true) */
  case class LoginuserRow(id: Int, username: String, password: String)
  /** GetResult implicit for fetching LoginuserRow objects using plain SQL queries */
  implicit def GetResultLoginuserRow(implicit e0: GR[Int], e1: GR[String]): GR[LoginuserRow] = GR{
    prs => import prs._
    (LoginuserRow.apply _).tupled((<<[Int], <<[String], <<[String]))
  }
  /** Table description of table loginuser. Objects of this class serve as prototypes for rows in queries. */
  class Loginuser(_tableTag: Tag) extends profile.api.Table[LoginuserRow](_tableTag, Some("dbo"), "loginuser") {
    def * = ((id, username, password)).mapTo[LoginuserRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(username), Rep.Some(password))).shaped.<>({r=>import r._; _1.map(_=> (LoginuserRow.apply _).tupled((_1.get, _2.get, _3.get)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(int identity), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column username SqlType(varchar), Length(50,true) */
    val username: Rep[String] = column[String]("username", O.Length(50,varying=true))
    /** Database column password SqlType(varchar), Length(200,true) */
    val password: Rep[String] = column[String]("password", O.Length(200,varying=true))
  }
  /** Collection-like TableQuery object for table Loginuser */
  lazy val Loginuser = new TableQuery(tag => new Loginuser(tag))
}
