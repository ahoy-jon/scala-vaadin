package scala.vaadin


import scala.ref._
//import com.vaadin.ui.

import scala.collection.mutable.HashMap
import scala.ref._
import java.util.WeakHashMap


object Component {
  
  private val ClientKey = "scala.vaadinWrapper"
    private[this] val wrapperCache = new WeakHashMap[com.vaadin.ui.Component, WeakReference[Component]]

    private def cache(e: Component) = e.peer match {
      //case p: com.vaadin.ui.Component => p.putClientProperty(ClientKey, e)
      case _ => wrapperCache.put(e.peer, new WeakReference(e))
    }

    /**
     * Looks up the internal component cache for a wrapper of the given 
     * Java Swing peer. If this method finds one of the given type `C`, 
     * it will return that wrapper. Otherwise it returns `null`. This 
     * method never throws an exception.
     * 
     * Clients should be extremely careful with type parameter `C` and 
     * its interaction with type inference. Better err on the side of caution 
     * and explicitly specify `C`.  
     */
    private[vaadin] def cachedWrapper[C>:Null<:Component](c: com.vaadin.ui.Component): C = {
      val w = c match {
        //case c: com.vaadin.ui.Component => c.getClientProperty(ClientKey)
        case _ => wrapperCache.get(c)
      }
      try { w.asInstanceOf[C] } catch { case _ => null }
    }

    /**
     * Returns a wrapper for a given Java Swing peer. If there is a 
     * compatible wrapper in use, this method will return it.
     * 
     * `wrap` methods in companion objects of subclasses of UIElement have the 
     * same behavior, except that they return more specific wrappers.
     */
    def wrap(c: com.vaadin.ui.Component): Component = {
      val w = cachedWrapper[Component](c)
      if (w != null) w 
      else new Component { def peer = c }
    }
}


trait Component extends Proxy /* with LazyPublisher */ {
  def peer : com.vaadin.ui.Component
  def self = peer
}