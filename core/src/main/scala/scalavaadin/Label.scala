package scalavaadin



object Label {

  case class ContentMode(oldIndex:Int)
  import com.vaadin.ui.Label._
  val Text = ContentMode(CONTENT_TEXT)
  val Preformated = ContentMode(CONTENT_PREFORMATTED)
  val XHTML = ContentMode(CONTENT_XHTML)
  val XML =  ContentMode(CONTENT_XML)
  val Raw = ContentMode(CONTENT_RAW)

  //def values() = Set(Text,Preformated,XHTML,XML,Raw)

}


import com.vaadin.ui.{Label => VLabel}

class Label(contentSource: Option[String], contentMode: Option[Label.ContentMode] ) extends Component 
with PeerProxy[VLabel] {
  override lazy val peer = 
    new VLabel(contentSource getOrElse "", (contentMode getOrElse Label.Text).oldIndex)


    def this() = this(None,None)
    def this(text: String) = this(Option(text),None)
    def this(text: String, contentMode: Label.ContentMode) = this(Option(text),Option(contentMode))

    def text: String = peer.getValue match {case s:String => s ; case _ => ""}
    def text_= (s: String): Unit = peer.setValue(s)

    def readOnly_= (isReadOnly: Boolean):Unit = peer.setReadOnly(isReadOnly)
    def isReadOnly: Boolean = peer.isReadOnly

    }

