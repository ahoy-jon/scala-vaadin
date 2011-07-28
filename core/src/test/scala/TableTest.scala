import org.scalatest.FunSuite
import scalavaadin.Table


class TableTest extends FunSuite {
  test("instance") {
    val t = new Table
    t.caption = "my Table"
  }
}