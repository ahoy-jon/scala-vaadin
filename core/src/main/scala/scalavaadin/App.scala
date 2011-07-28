package scalavaadin

import com.vaadin.{Application => VApplication}
import scala.collection.mutable.ListBuffer

/** The `App` trait can be used to quickly turn objects 
 *  into Vaadin Application, much like the original Scala App trait [1].
 *  {{{
 *   class MyApp extends scalavaadin.App {
 *     mainWindow = new Window {add(new Label("Hello World !"))}
 *   }  
 *
 *  }}}
 *
 *
 *  - [1] Original Scala App Trait is better used with objects, but this trait has
 * to be extended by a class.
 */
trait App extends VApplication with DelayedInit  {
    
    private val initCode = new ListBuffer[() => Unit]

    /** The init hook. This saves all initialization code for execution within `init`.
     *  This method is normally never called directly from user code.
     *  Instead it is called as compiler-generated code for those classes and objects
     *  (but not traits) that inherit from the `DelayedInit` trait and that do not
     *  themselves define a `delayedInit` method.
     *  @param body the initialization code to be stored for later execution
     */
    final override def delayedInit(body: => Unit) {
        initCode += (() => body)
    }

    /** The init method.
     *  When called, executes all initialization code segments in the order the were
     *  passed to `delayedInit`
     */
    final override def init() : Unit = {
        for (proc <- initCode) proc()
    }
    
    final def peer = this
    
    final def mainWindow : MainWindow = TPPRegistry.wrap(getMainWindow)

    
    final def mainWindow_= (window: Window):Unit = {setMainWindow(window.peer)}
    
    final def theme: Option[String] = Option(peer.getTheme())
    final def theme_= (t : Option[String]): Unit = peer.setTheme(t getOrElse null)
    final def theme_= (t: String) : Unit = peer.setTheme(t)
}
