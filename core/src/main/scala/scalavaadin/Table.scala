package scalavaadin


import com.vaadin.ui.{Table => VaadinTable}
import Container._

class Table extends Component with Viewer  with TerminalPeerProxy[VaadinTable] {
   lazy val peerManifest = implicitly[Manifest[VaadinTable]]
}