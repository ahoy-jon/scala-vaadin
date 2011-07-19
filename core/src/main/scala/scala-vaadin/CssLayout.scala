package scala.vaadin
import com.vaadin.ui.{CssLayout => VCssLayout}


class CssLayout extends Layout with VaadinProxy[VCssLayout] {
  override lazy val peer = new VCssLayout()
}