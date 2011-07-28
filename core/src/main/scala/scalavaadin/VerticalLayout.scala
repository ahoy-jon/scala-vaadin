package scalavaadin

import com.vaadin.ui.{VerticalLayout => VaadinLayout}



class VerticalLayout extends Layout with TerminalPeerProxy[VaadinLayout] {
  final override val peerManifest = implicitly[Manifest[VaadinLayout]]
}