/**
 * Created by tanglei on 8/23/15.
 */
import scala.slick.codegen.SourceCodeGenerator

object SlickCodeGen{

  def main(args: Array[String]): Unit = {
    val slickDriver = "scala.slick.driver.MySQLDriver"
    val jdbcDriver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://127.0.0.1:3306/slicktest?characterEncoding=UTF-8&useUnicode=true"
    val outputFolder = "src/main/scala"
    val pkg = "model.name.tanglei"
    val user = "root"
    val password = "root"

    SourceCodeGenerator.main(
      Array(
        slickDriver,
        jdbcDriver,
        url,
        outputFolder,
        pkg,
        user,
        password
      )
    )
  }
}
