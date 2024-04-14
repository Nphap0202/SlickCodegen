package com.mypackage
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
  lazy val schema: profile.SchemaDescription = Items.schema ++ Sysdiagrams.schema ++ Users.schema

  /** Entity class storing rows of table Items
   *  @param itemId Database column item_id SqlType(int identity), AutoInc, PrimaryKey
   *  @param userId Database column user_id SqlType(int)
   *  @param text Database column text SqlType(varchar), Length(2000,true) */
  case class ItemsRow(itemId: Int, userId: Int, text: String)
  /** GetResult implicit for fetching ItemsRow objects using plain SQL queries */
  implicit def GetResultItemsRow(implicit e0: GR[Int], e1: GR[String]): GR[ItemsRow] = GR{
    prs => import prs._
    (ItemsRow.apply _).tupled((<<[Int], <<[Int], <<[String]))
  }
  /** Table description of table items. Objects of this class serve as prototypes for rows in queries. */
  class Items(_tableTag: Tag) extends profile.api.Table[ItemsRow](_tableTag, Some("dbo"), "items") {
    def * = ((itemId, userId, text)).mapTo[ItemsRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(itemId), Rep.Some(userId), Rep.Some(text))).shaped.<>({r=>import r._; _1.map(_=> (ItemsRow.apply _).tupled((_1.get, _2.get, _3.get)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column item_id SqlType(int identity), AutoInc, PrimaryKey */
    val itemId: Rep[Int] = column[Int]("item_id", O.AutoInc, O.PrimaryKey)
    /** Database column user_id SqlType(int) */
    val userId: Rep[Int] = column[Int]("user_id")
    /** Database column text SqlType(varchar), Length(2000,true) */
    val text: Rep[String] = column[String]("text", O.Length(2000,varying=true))

    /** Foreign key referencing Users (database name FK_items_users) */
    lazy val usersFk = foreignKey("FK_items_users", userId, Users)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Items */
  lazy val Items = new TableQuery(tag => new Items(tag))

  /** Entity class storing rows of table Sysdiagrams
   *  @param name Database column name SqlType(sysname), Length(128,true)
   *  @param principalId Database column principal_id SqlType(int)
   *  @param diagramId Database column diagram_id SqlType(int identity), AutoInc, PrimaryKey
   *  @param version Database column version SqlType(int)
   *  @param definition Database column definition SqlType(varbinary) */
  case class SysdiagramsRow(name: String, principalId: Int, diagramId: Int, version: Option[Int], definition: Option[java.sql.Blob])
  /** GetResult implicit for fetching SysdiagramsRow objects using plain SQL queries */
  implicit def GetResultSysdiagramsRow(implicit e0: GR[String], e1: GR[Int], e2: GR[Option[Int]], e3: GR[Option[java.sql.Blob]]): GR[SysdiagramsRow] = GR{
    prs => import prs._
    (SysdiagramsRow.apply _).tupled((<<[String], <<[Int], <<[Int], <<?[Int], <<?[java.sql.Blob]))
  }
  /** Table description of table sysdiagrams. Objects of this class serve as prototypes for rows in queries. */
  class Sysdiagrams(_tableTag: Tag) extends profile.api.Table[SysdiagramsRow](_tableTag, Some("dbo"), "sysdiagrams") {
    def * = ((name, principalId, diagramId, version, definition)).mapTo[SysdiagramsRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(name), Rep.Some(principalId), Rep.Some(diagramId), version, definition)).shaped.<>({r=>import r._; _1.map(_=> (SysdiagramsRow.apply _).tupled((_1.get, _2.get, _3.get, _4, _5)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column name SqlType(sysname), Length(128,true) */
    val name: Rep[String] = column[String]("name", O.Length(128,varying=true))
    /** Database column principal_id SqlType(int) */
    val principalId: Rep[Int] = column[Int]("principal_id")
    /** Database column diagram_id SqlType(int identity), AutoInc, PrimaryKey */
    val diagramId: Rep[Int] = column[Int]("diagram_id", O.AutoInc, O.PrimaryKey)
    /** Database column version SqlType(int) */
    val version: Rep[Option[Int]] = column[Option[Int]]("version")
    /** Database column definition SqlType(varbinary) */
    val definition: Rep[Option[java.sql.Blob]] = column[Option[java.sql.Blob]]("definition")

    /** Uniqueness Index over (principalId,name) (database name UK_principal_name) */
    val index1 = index("UK_principal_name", (principalId, name), unique=true)
  }
  /** Collection-like TableQuery object for table Sysdiagrams */
  lazy val Sysdiagrams = new TableQuery(tag => new Sysdiagrams(tag))

  /** Entity class storing rows of table Users
   *  @param id Database column id SqlType(int identity), AutoInc, PrimaryKey
   *  @param username Database column username SqlType(varchar), Length(20,true)
   *  @param password Database column password SqlType(varchar), Length(200,true) */
  case class UsersRow(id: Int, username: String, password: String)
  /** GetResult implicit for fetching UsersRow objects using plain SQL queries */
  implicit def GetResultUsersRow(implicit e0: GR[Int], e1: GR[String]): GR[UsersRow] = GR{
    prs => import prs._
    (UsersRow.apply _).tupled((<<[Int], <<[String], <<[String]))
  }
  /** Table description of table users. Objects of this class serve as prototypes for rows in queries. */
  class Users(_tableTag: Tag) extends profile.api.Table[UsersRow](_tableTag, Some("dbo"), "users") {
    def * = ((id, username, password)).mapTo[UsersRow]
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(username), Rep.Some(password))).shaped.<>({r=>import r._; _1.map(_=> (UsersRow.apply _).tupled((_1.get, _2.get, _3.get)))}, (_:Any) => throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(int identity), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column username SqlType(varchar), Length(20,true) */
    val username: Rep[String] = column[String]("username", O.Length(20,varying=true))
    /** Database column password SqlType(varchar), Length(200,true) */
    val password: Rep[String] = column[String]("password", O.Length(200,varying=true))
  }
  /** Collection-like TableQuery object for table Users */
  lazy val Users = new TableQuery(tag => new Users(tag))
}
