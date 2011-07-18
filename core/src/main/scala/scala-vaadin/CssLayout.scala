package scala.vaadin
import com.vaadin.ui.{CssLayout => VCssLayout}


class CssLayout extends Layout {
  override lazy val peer: VCssLayout = new VCssLayout()
}