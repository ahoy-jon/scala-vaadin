package scala.vaadin.demo
import scala.vaadin._

class AppDemo extends App {
  mainWindow = Window("ahoy 2")
   
  mainWindow.add(new Label {text = "ahoy"})
  //mainWindow.add(Label(mainWindow.name))
  
}



