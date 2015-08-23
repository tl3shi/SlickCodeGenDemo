package model.name.tanglei
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = scala.slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}
  
  /** DDL for all tables. Call .create to execute. */
  lazy val ddl = Sqlquerytask.ddl ++ User.ddl
  
  /** Entity class storing rows of table Sqlquerytask
   *  @param id Database column id DBType(INT), AutoInc, PrimaryKey
   *  @param sqlquery Database column sqlQuery DBType(TEXT), Length(65535,true)
   *  @param description Database column description DBType(VARCHAR), Length(128,true), Default(None)
   *  @param crondesc Database column cronDesc DBType(VARCHAR), Length(64,true), Default(None)
   *  @param status Database column status DBType(VARCHAR), Length(20,true), Default(None)
   *  @param createdtime Database column createdTime DBType(DATETIME), Default(None)
   *  @param mailto Database column mailTo DBType(VARCHAR), Length(256,true), Default(None)
   *  @param extinfo Database column extInfo DBType(TEXT), Length(65535,true), Default(None)
   *  @param createduserid Database column createdUserId DBType(INT), Default(None) */
  case class SqlquerytaskRow(id: Int, sqlquery: String, description: Option[String] = None, crondesc: Option[String] = None, status: Option[String] = None, createdtime: Option[java.sql.Timestamp] = None, mailto: Option[String] = None, extinfo: Option[String] = None, createduserid: Option[Int] = None)
  /** GetResult implicit for fetching SqlquerytaskRow objects using plain SQL queries */
  implicit def GetResultSqlquerytaskRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]], e3: GR[Option[java.sql.Timestamp]], e4: GR[Option[Int]]): GR[SqlquerytaskRow] = GR{
    prs => import prs._
    SqlquerytaskRow.tupled((<<[Int], <<[String], <<?[String], <<?[String], <<?[String], <<?[java.sql.Timestamp], <<?[String], <<?[String], <<?[Int]))
  }
  /** Table description of table SqlQueryTask. Objects of this class serve as prototypes for rows in queries. */
  class Sqlquerytask(_tableTag: Tag) extends Table[SqlquerytaskRow](_tableTag, "SqlQueryTask") {
    def * = (id, sqlquery, description, crondesc, status, createdtime, mailto, extinfo, createduserid) <> (SqlquerytaskRow.tupled, SqlquerytaskRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, sqlquery.?, description, crondesc, status, createdtime, mailto, extinfo, createduserid).shaped.<>({r=>import r._; _1.map(_=> SqlquerytaskRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8, _9)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id DBType(INT), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column sqlQuery DBType(TEXT), Length(65535,true) */
    val sqlquery: Column[String] = column[String]("sqlQuery", O.Length(65535,varying=true))
    /** Database column description DBType(VARCHAR), Length(128,true), Default(None) */
    val description: Column[Option[String]] = column[Option[String]]("description", O.Length(128,varying=true), O.Default(None))
    /** Database column cronDesc DBType(VARCHAR), Length(64,true), Default(None) */
    val crondesc: Column[Option[String]] = column[Option[String]]("cronDesc", O.Length(64,varying=true), O.Default(None))
    /** Database column status DBType(VARCHAR), Length(20,true), Default(None) */
    val status: Column[Option[String]] = column[Option[String]]("status", O.Length(20,varying=true), O.Default(None))
    /** Database column createdTime DBType(DATETIME), Default(None) */
    val createdtime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("createdTime", O.Default(None))
    /** Database column mailTo DBType(VARCHAR), Length(256,true), Default(None) */
    val mailto: Column[Option[String]] = column[Option[String]]("mailTo", O.Length(256,varying=true), O.Default(None))
    /** Database column extInfo DBType(TEXT), Length(65535,true), Default(None) */
    val extinfo: Column[Option[String]] = column[Option[String]]("extInfo", O.Length(65535,varying=true), O.Default(None))
    /** Database column createdUserId DBType(INT), Default(None) */
    val createduserid: Column[Option[Int]] = column[Option[Int]]("createdUserId", O.Default(None))
    
    /** Foreign key referencing User (database name sqlquerytask_ibfk_1) */
    lazy val userFk = foreignKey("sqlquerytask_ibfk_1", createduserid, User)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Sqlquerytask */
  lazy val Sqlquerytask = new TableQuery(tag => new Sqlquerytask(tag))
  
  /** Entity class storing rows of table User
   *  @param id Database column id DBType(INT), AutoInc, PrimaryKey
   *  @param name Database column name DBType(VARCHAR), Length(64,true)
   *  @param hashedPassword Database column hashed_password DBType(CHAR), Length(128,false)
   *  @param salt Database column salt DBType(CHAR), Length(32,false)
   *  @param created Database column created DBType(TIMESTAMP) */
  case class UserRow(id: Int, name: String, hashedPassword: String, salt: String, created: Option[java.sql.Timestamp])
  /** GetResult implicit for fetching UserRow objects using plain SQL queries */
  implicit def GetResultUserRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[java.sql.Timestamp]]): GR[UserRow] = GR{
    prs => import prs._
    UserRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<?[java.sql.Timestamp]))
  }
  /** Table description of table user. Objects of this class serve as prototypes for rows in queries. */
  class User(_tableTag: Tag) extends Table[UserRow](_tableTag, "user") {
    def * = (id, name, hashedPassword, salt, created) <> (UserRow.tupled, UserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, name.?, hashedPassword.?, salt.?, created).shaped.<>({r=>import r._; _1.map(_=> UserRow.tupled((_1.get, _2.get, _3.get, _4.get, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id DBType(INT), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name DBType(VARCHAR), Length(64,true) */
    val name: Column[String] = column[String]("name", O.Length(64,varying=true))
    /** Database column hashed_password DBType(CHAR), Length(128,false) */
    val hashedPassword: Column[String] = column[String]("hashed_password", O.Length(128,varying=false))
    /** Database column salt DBType(CHAR), Length(32,false) */
    val salt: Column[String] = column[String]("salt", O.Length(32,varying=false))
    /** Database column created DBType(TIMESTAMP) */
    val created: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created")
    
    /** Uniqueness Index over (name) (database name name) */
    val index1 = index("name", name, unique=true)
  }
  /** Collection-like TableQuery object for table User */
  lazy val User = new TableQuery(tag => new User(tag))
}