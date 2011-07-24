package scala.vaadin


import com.vaadin.ui.{Window => VWindow}

object Window {

}


class Window(caption: Option[String],content: Option[ComponentContainer]) 
extends Panel with PeerProxy[VWindow] {

  override lazy val peer = 
    new VWindow(caption getOrElse "", content map {_.peer} getOrElse null)

    def this() = 
      this(None, None)
    def this(caption: String) = 
      this(Option(caption), None)
    def this(caption: String, content: ComponentContainer) = 
      this(Option(caption), Option(content))



    /**
     * Gets the full URL of the window. The returned URL is window specific and
     * can be used to directly refer to the window.
     * <p>
     * Note! This method can not be used for portlets.
     * </p>
     * 
     * @return the URL of the window or null if the window is not attached to an
     *         application
     */
    final def url = peer.getURL()

    /**
     * <b>Application window only</b>. Gets the theme for this window.
     * <p>
     * If the theme for this window is not explicitly set, the application theme
     * name is returned. If the window is not attached to an application, the
     * terminal default theme name is returned. If the theme name cannot be
     * determined, None is returned
     * </p>
     * <p>
     * Subwindows do not support themes and return the theme used by the parent
     * window
     * </p>
     * 
     * @return the name of the theme used for the window
     */
    final def theme: Option[String] = Option(peer.getTheme())




    /**
     * Returns the closable status of the sub window. If a sub window is
     * closable it typically shows an X in the upper right corner. Clicking on
     * the X sends a close event to the server. Setting closable to false will
     * remove the X from the sub window and prevent the user from closing the
     * window.
     * 
     * Note! For historical reasons readonly controls the closability of the sub
     * window and therefore readonly and closable affect each other. Setting
     * readonly to true will set closable to false and vice versa.
     * <p/>
     * Closable only applies to sub windows, not to browser level windows.
     * 
     * @return true if the sub window can be closed by the user.
     */
    final def isClosable : Boolean = peer isClosable

    /**
     * Sets the closable status for the sub window. If a sub window is closable
     * it typically shows an X in the upper right corner. Clicking on the X
     * sends a close event to the server. Setting closable to false will remove
     * the X from the sub window and prevent the user from closing the window.
     * 
     * Note! For historical reasons readonly controls the closability of the sub
     * window and therefore readonly and closable affect each other. Setting
     * readonly to true will set closable to false and vice versa.
     * <p/>
     * Closable only applies to sub windows, not to browser level windows.
     * 
     * @param closable
     *            determines if the sub window can be closed by the user.
     */
    final def closable_= (isClosable: Boolean): Unit = peer setClosable(isClosable)









    }



class MainWindow extends Window(None,None) {

  final def name = peer.getName()

  /**
   * Sets the name of the theme to use for
   * this window. Changing the theme will cause the page to be reloaded.
   * 
   * @param theme
   *        the name of the new theme for this window or None to use the
   *        application theme.
   */
  final def theme_=(theme: Option[String]): Unit = {peer.setTheme(theme getOrElse null)}

  }


