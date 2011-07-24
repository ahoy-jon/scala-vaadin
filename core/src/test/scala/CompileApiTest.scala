import com.vaadin.ui.themes.Reindeer
import scala.vaadin.{HorizontalLayout, Label}


import org.scalatest.FunSuite

class RamdomBlockSuite extends FunSuite {
  test("code") {
    class H2(caption: String) extends Label(caption) {
      sizeUndefined()
      styleName = Reindeer.LABEL_H2
    }
    class H1(caption: String) extends Label(caption) {
      sizeUndefined
      styleName = Reindeer.LABEL_H1
    }

    class SmallText(caption: String) extends Label(caption) {
      styleName = Reindeer.LABEL_SMALL
    }

    class Ruler extends Label("<hr />", Label.XHTML)

    val header = new HorizontalLayout()
    header.width = "100%"
    header.margin = true
    header.spacing = true
  }
}




