package scala.vaadin


import scala.ref._
import com.vaadin.ui._


trait Component extends Proxy /* with LazyPublisher */ {
  def peer : com.vaadin.ui.AbstractComponent
  def self = peer

}
