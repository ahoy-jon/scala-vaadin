package scalavaadin

import java.lang.Boolean

trait Layout extends ComponentContainer with PeerProxy[com.vaadin.ui.AbstractLayout] {
  def margin = peer.getMargin()
  def margin_= (t: (scala.Boolean,scala.Boolean,scala.Boolean,scala.Boolean)) = peer.setMargin(t._1,t._2,t._3,t._4)
  def margin_= (t: Boolean): Unit = peer.setMargin(t)
}

trait SpacingHandler extends PeerProxy[com.vaadin.ui.Layout.SpacingHandler] {
  final def spacing: Boolean = peer.isSpacing
  final def spacing_=(spacing: Boolean): Unit = peer.setSpacing(spacing)
}