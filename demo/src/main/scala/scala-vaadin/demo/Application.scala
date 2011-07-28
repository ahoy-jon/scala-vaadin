package scala.vaadin.demo

import scalavaadin._
import com.vaadin.ui.themes.Reindeer

class AppDemo extends App {

  theme = "reindeer"
  mainWindow = new Window {
    caption = "Vaadin Reindeer Theme"
  }

  val verticalLayout:Option[VerticalLayout] = mainWindow.content.wrap

  buildMainView()

  def buildMainView() {
    val mainLayout: Option[VerticalLayout] = mainWindow.content.wrap


    mainLayout map {

      v: VerticalLayout =>
        v.sizeFull()
        v.add(topMenu)
        v.add(header)
    }


    val margin = new CssLayout()
  }

  def topMenu(): Component = {
    new Label("topMenu") {
      styleName = Reindeer.LABEL_H2
    }
  }

  def header(): Component = {
    new Label("header")
  }

}




