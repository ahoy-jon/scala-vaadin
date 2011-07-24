package scala.vaadin


import com.vaadin.ui.{MenuBar => VMenuBar}


class MenuBar extends Component with PeerProxy[VMenuBar] {
  override lazy val peer = new VMenuBar()


  /**
   * Size of the menu
   */ 
  def size(): Int = peer.getSize()









}
