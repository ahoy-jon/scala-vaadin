package scala.vaadin

import com.vaadin.ui.{VerticalLayout => VLayout}

object VerticalLayout {
  
  def wrap (c: VLayout): VerticalLayout = {
    val w = Component.cachedWrapper[VerticalLayout](c)
    if (w != null) w
    else new VerticalLayout { override lazy val peer = c }
  }
}


class VerticalLayout extends Layout with PeerProxy[VLayout] {
  override lazy val peer = new VLayout()
  
  
  
}