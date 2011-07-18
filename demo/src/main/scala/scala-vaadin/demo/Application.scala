package scala.vaadin.demo
import scala.vaadin._

class AppDemo extends App {
 
  theme = "reindeer"
  mainWindow = new Window("Vaadin Reindeer Theme")
  mainWindow.content.wrap[VerticalLayout] map {_.margin = false }
  buildMainView()
  
  def buildMainView() {
    val mainLayout = mainWindow.content.wrap[VerticalLayout]
    
    mainLayout map {v:VerticalLayout => 
      v.sizeFull()
      v.add(topMenu)
      v.add(header)
    }
    
    val margin = new CssLayout()
  }
  
  def topMenu(): Component = {
     new Label("topMenu")
  }
  
  def header(): Component = {
    new Label("header")
  }
  
}




