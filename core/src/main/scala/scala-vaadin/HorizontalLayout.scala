package scala.vaadin

class HorizontalLayout extends Layout with SpacingHandler with PeerProxy[com.vaadin.ui.HorizontalLayout] {
   override lazy val peer = new com.vaadin.ui.HorizontalLayout()
}