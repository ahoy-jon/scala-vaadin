package scala.vaadin.demo
import scala.vaadin.App

import com.vaadin.ui._

class AppDemo extends App {
    
    var hlayout: HorizontalLayout = null
    var detailwindow: Window = null
   // setTheme("mytheme")
       detailwindow = new Window("Inspector")
       val layout = detailwindow.getContent.asInstanceOf[VerticalLayout]
       layout.setMargin(true)
       layout.setSpacing(true)
       detailwindow.addComponent(new Label("Content in the inspector window"))
       val open = new Button("Inspector", new Button.ClickListener {
         def buttonClick(event: Button#ClickEvent): Unit = {
           if (detailwindow.getParent != null) {
             getMainWindow.removeWindow(detailwindow)
           }
           else {
             getMainWindow.addWindow(detailwindow)
             detailwindow.setPositionX(30)
             detailwindow.setPositionY(100)
             detailwindow.setHeight("40%")
           }
         }
       })
      // open.setIcon(Application.ICON)

       val richText = new Label("<h1>Opups <i>AHOY</i></h1>") {
         setContentMode(Label.CONTENT_XHTML)
       }

       val toolbar = new HorizontalLayout {
         setSizeFull
         addComponent(open)
         setComponentAlignment(open, Alignment.TOP_LEFT)
       }


       val mainLayout = new VerticalLayout {
         addComponent(richText)
         addComponent(toolbar)
        // addComponent(twitterlayout)
         setComponentAlignment(richText, Alignment.MIDDLE_LEFT)
         setWidth("750px")
         setSpacing(true)
       }




       val globalLayout = new VerticalLayout {
         addComponent(mainLayout)
         setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER)
       }


       val mainwindow = new Window {
         addComponent(globalLayout)
         setBorder(1)
       }

       this.setMainWindow(mainwindow)
}