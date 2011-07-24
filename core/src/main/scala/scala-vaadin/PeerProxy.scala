package scala.vaadin

import proxy.AProxy


package proxy {

trait AProxy[+A] extends Proxy {
  def peer: A

  def self = peer

}

}

trait PeerProxy[+A] extends AProxy[A] {
  override def peer: A
}

object PeerProxy {
  def wrapIn[A, C](w: C)(implicit m: Manifest[A]): A = m.erasure.newInstance().asInstanceOf[A]
}