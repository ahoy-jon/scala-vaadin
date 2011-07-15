package scala.vaadin



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

class Label(contentSource:String, contentMode: Label.ContentMode ) extends Component {
    override lazy val peer = new VLabel(contentSource, contentMode.oldIndex)
    
    def this() = this("", Label.Text)
    def this(contentSource:String) = this(contentSource, Label.Text)
    
    def readOnly_(isReadOnly: Boolean) = peer.setReadOnly(isReadOnly)
    def readOnly : Boolean = peer.isReadOnly
}
 