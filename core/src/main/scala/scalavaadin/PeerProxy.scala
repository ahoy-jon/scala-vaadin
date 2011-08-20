package scalavaadin

import java.util.WeakHashMap
import java.lang.ref.WeakReference
import java.lang.System._

/**
 * Root of PeerProxy's. Can only be extended by PeerProxys
 */
sealed trait AProxy[+A] extends Proxy {
  def peer: A

  def self = peer

  private[scalavaadin] def preDefPeer: Option[A]
  private[scalavaadin] def preDefPeer_=[B >: A](ppeer: Option[B]): Unit
}

trait PeerProxy[+A] extends AProxy[A] {
  override def peer: A


  private var _preDefPeer: Option[Any] = None
  override private[scalavaadin] def preDefPeer: Option[A] = _preDefPeer.asInstanceOf[Option[A]]

  override private[scalavaadin] def preDefPeer_=[B](ppeer: Option[B]): Unit = {
    _preDefPeer = ppeer.asInstanceOf[Option[A]]
  }

}

trait TerminalPeerProxy[A] extends PeerProxy[A] {
  def peerManifest: Manifest[A]

  def peer: A = preDefPeer getOrElse peerManifest.erasure.newInstance().asInstanceOf[A]

}

import com.weiglewilczek.slf4s._
object TPPRegistry extends Logging {

  import scala.reflect.Manifest

  private[scalavaadin] var _map = new WeakHashMap[Any, WeakReference[Any]]

  def put[B, A <: PeerProxy[B]](key: B, item: A) {
    import java.lang.System.identityHashCode
    
    logger.debug("Associate " + identityHashCode(key) + "with" + identityHashCode(item))
    _map.put(key, new WeakReference(item))
  }

  def put[B, A <: PeerProxy[B]](item: A) {
    put(item.peer, item)
  }

  def get[A <: PeerProxy[_]](key: Any): Option[A] = {
    val ref: Option[WeakReference[Any]] = Option(_map.get(key))
    val o: Option[Any] = ref map (_.get)

    o map  {o => logger.debug("get " + identityHashCode(o) + " : " + o + " for " + identityHashCode(key))}

    try {
      o map  (_.asInstanceOf[A])
    } catch {
      case e: Exception => None
    }
  }

  def wrap[A <: PeerProxy[_]](key: Any)(implicit m: Manifest[A]): A = {
    val o = get[A](key)
    o getOrElse {
      def ni[T](implicit mt: Manifest[T]): A = mt.erasure.newInstance().asInstanceOf[A]

      val a: A = key match {
        case key:com.vaadin.ui.Table => ni[Table]
        case key:com.vaadin.ui.Label => ni[Label]
        case _ =>   m.erasure.newInstance().asInstanceOf[A]
      }

      a.preDefPeer = Option(key)
      put(key,a)
      a
    }
  }

  def wrap(key: com.vaadin.ui.Table): scalavaadin.Table = wrap[scalavaadin.Table](key)
  def wrap(key: com.vaadin.ui.Label): scalavaadin.Label = wrap[scalavaadin.Label](key)
  def wrap(key: com.vaadin.ui.Window): scalavaadin.Window = wrap[scalavaadin.Window](key)
  def wrap(key: com.vaadin.ui.HorizontalLayout): scalavaadin.HorizontalLayout = wrap[scalavaadin.HorizontalLayout](key)
}


