package scalavaadin

/**
 * @author Jonathan WINANDY
 * @todo DOC
 */

object Container {

  import com.vaadin.data.Container.{Viewer => VaadinViewer}

  trait Viewer extends PeerProxy[VaadinViewer] {
    /**
     *  Gets the Container serving as the data source of the viewer.
     */
    final def containerDataSource: Container = TPPRegistry.wrap(peer.getContainerDataSource)

    /**
     * Sets the Container that serves as the data source of the viewer.
     */
    final def containerDataSource_=(container: Container): Unit = peer.setContainerDataSource(container.peer)
  }

}

import com.vaadin.data.{Container => VaadinContainer}

trait Container extends PeerProxy[VaadinContainer] {


}