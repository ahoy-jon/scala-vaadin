package scala.vaadin

import com.vaadin.{Application => VApplication}
import scala.collection.mutable.ListBuffer


trait App extends VApplication with DelayedInit  {
    private val initCode = new ListBuffer[() => Unit]
    override def delayedInit(body: => Unit) {
        initCode += (() => body)
    }

    override def init() : Unit = {
        for (proc <- initCode) proc()
    }
    
}
