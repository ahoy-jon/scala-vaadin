package scala.vaadin

import com.vaadin.ui.{AbstractComponentContainer => VComponentContainer}

object ComponentContainer {
  
  /**
   * Returns a wrapper for a given Java Swing peer. If there is a 
   * compatible wrapper in use, this method will return it.
   * 
   * `wrap` methods in companion objects of subclasses of UIElement have the 
   * same behavior, except that they return more specific wrappers.
   */
  def wrap(c: VComponentContainer): ComponentContainer = {
    val w = Component.cachedWrapper[ComponentContainer](c)
    if (w != null) w
    else new ComponentContainer { def peer = c }
  }
}

trait ComponentContainer extends Component with PeerProxy[VComponentContainer] {
    
    final def addComponent(c : Component) {
      peer.addComponent(c.peer)
    }

    final def add[T](t : T) {
      t match {
        case t:Component => addComponent(t)
      }
    }
}