package scalavaadin




trait Component extends Sizeable with PeerProxy[com.vaadin.ui.Component] {


  final def styleName: String = peer.getStyleName

  final def styleName_=(style: String): Unit = peer.setStyleName(style)

  final def caption: String = peer.getCaption

  final def caption_=(s: String) = peer.setCaption(s)

  final def wrap[A <: PeerProxy[_]](implicit m:Manifest[A]) : Option[A] = Option(TPPRegistry.wrap[ A](this.peer))

}
