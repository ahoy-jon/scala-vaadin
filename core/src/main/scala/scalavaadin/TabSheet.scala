package scalavaadin


final class TabSheet extends ComponentContainer with PeerProxy[com.vaadin.ui.TabSheet]{
  override lazy val peer = new com.vaadin.ui.TabSheet()

}