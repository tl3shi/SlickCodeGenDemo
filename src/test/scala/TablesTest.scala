/**
 * Created by tanglei on 8/23/15.
 */

import java.sql.Timestamp

import model.name.tanglei.Tables
import model.name.tanglei.Tables.UserRow

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.util.Logging

object TablesTest extends Logging{

  def main (args: Array[String]) {

    //System.setProperty("logger.scala.slick.jdbc.JdbcBackend.statement", "INFO") //no effect
    //slick.jdbc.JdbcBackend.statementLogger.isDebugEnabled = TRUE; // no effect
    //run with command para -Dorg.slf4j.simpleLogger.log.scala.slick=debug //output too much info

    Database.forURL(
      url = "jdbc:mysql://localhost:3306/slicktest?characterEncoding=UTF-8&useUnicode=true",
      user = "root",
      password = "root",
      driver = "com.mysql.jdbc.Driver") withSession {
      implicit session =>
        //add new user
        var query = Tables.User.filter(_.name === "tanglei")
        println(query.selectStatement)
        if (query.length == 0) {
          Tables.User += UserRow(0, "tanglei", "hashpwd", "salt", Option(new Timestamp(System.currentTimeMillis())));
          println(query.selectStatement)
        }
        query = Tables.User.filter(_.name === "tanglei2")
        println(query.selectStatement)
        if (query.length == 0) {
          Tables.User += UserRow(0, "tanglei2", "hashpwd", "salt", Option(new Timestamp(System.currentTimeMillis())));
          println(query.selectStatement)
        }
        Tables.User.list.foreach(println)
    }
  }
}
