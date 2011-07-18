package scala.vaadin

import com.vaadin.ui.{VerticalLayout => VLayout}

object VerticalLayout {
  
  def wrap (c: VLayout): VerticalLayout = {
    val w = Component.cachedWrapper[VerticalLayout](c)
    if (w != null) w
    else new VerticalLayout { override lazy val peer = c }
  }
}


class VerticalLayout extends  ComponentContainer with Layout {
  override lazy val peer: VLayout = new VLayout()
  
  
  
}