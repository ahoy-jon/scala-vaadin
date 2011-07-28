package scalavaadin

import com.vaadin.ui.{AbstractComponentContainer => VComponentContainer}

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