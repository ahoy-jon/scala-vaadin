package scala.vaadin
import com.vaadin.ui.{CssLayout => VCssLayout}


class CssLayout extends Layout with PeerProxy[VCssLayout] {
  override lazy val peer = new VCssLayout()
}