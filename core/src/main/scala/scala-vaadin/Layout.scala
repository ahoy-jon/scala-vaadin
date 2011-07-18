package scala.vaadin
import com.vaadin.ui.{AbstractLayout => VLayout}

trait Layout extends ComponentContainer {
  
  override def peer: VLayout
  
  def margin:Any = peer.getMargin()
  def margin_= (t: Boolean): Unit = peer.setMargin(t)
}