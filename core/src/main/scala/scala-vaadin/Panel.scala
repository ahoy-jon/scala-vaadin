package scala.vaadin



import com.vaadin.ui.{Panel => VPanel}

trait Panel extends Component with VaadinProxy[VPanel] {
  def content: ComponentContainer =
    ComponentContainer.wrap(peer.getContent.
      asInstanceOf[com.vaadin.ui.AbstractComponentContainer])
}