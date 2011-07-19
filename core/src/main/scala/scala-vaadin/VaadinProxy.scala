package scala.vaadin


trait CustomProxy[+A] extends Proxy {
  def peer : A
  def self = peer
}

trait VaadinProxy[+B] extends CustomProxy[B] {
  override def peer: B
}