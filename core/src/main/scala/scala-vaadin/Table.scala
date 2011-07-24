package scala.vaadin

import com.vaadin.ui.Table


class Table extends Component with PeerProxy[com.vaadin.ui.Table] {
  override lazy val peer = new com.vaadin.ui.Table()

}