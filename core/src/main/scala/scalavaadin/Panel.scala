package scalavaadin



import com.vaadin.ui.{Panel => VPanel}

trait Panel extends ComponentContainer with PeerProxy[VPanel] {
  def content: ComponentContainer = TPPRegistry.wrap(peer.getContent).asInstanceOf[ComponentContainer]
}