package scala.vaadin


final object Vaadin {

  def wrap[T : Manifest](a: AnyRef): Option[T] = {
    val value = a match {
      case v: com.vaadin.ui.VerticalLayout => (v)
      case v: com.vaadin.ui.Table => new Table() {override lazy val peer = v}
      case _ => None
    }
    value match {
      case t: T => Option[T](t)
      case _ => None
    }
  }
}