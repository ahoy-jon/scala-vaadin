package scala.vaadin
import com.vaadin.ui.{AbstractLayout => VLayout}

trait Layout extends ComponentContainer with VaadinProxy[VLayout] {
  def margin:Any = peer.getMargin()
  def margin_= (t: Boolean): Unit = peer.setMargin(t)
}