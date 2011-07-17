package scala.vaadin

import com.vaadin.ui.{ComponentContainer => VComponentContainer}

trait ComponentContainer extends Component {
    override def peer: VComponentContainer
}