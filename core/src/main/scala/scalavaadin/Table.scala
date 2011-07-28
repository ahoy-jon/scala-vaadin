package scalavaadin


import com.vaadin.ui.{Table => VaadinTable}

class Table extends Component with TerminalPeerProxy[VaadinTable] {
   lazy val peerManifest = implicitly[Manifest[VaadinTable]]
}