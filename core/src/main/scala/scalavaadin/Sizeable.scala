package scalavaadin

import java.lang.Float



object Size {

  import com.vaadin.terminal.Sizeable._

  val Undefined = SIZE_UNDEFINED
}

object Units {

  sealed case class SizeUnit(self: Int)
  private[scalavaadin] implicit def convIntToSizeUnit(i: Int): SizeUnit = new SizeUnit(i)
  private[scalavaadin] implicit def convSizeUnitToInt(s: SizeUnit): Int = s.self

  import com.vaadin.terminal.Sizeable._
  /**
   *  Unit code representing the font-size of the relevant font.
   */
  val em: SizeUnit = UNITS_EM
  /**
   *    Unit code representing the x-height of the relevant font.
   */
  val ex: SizeUnit = UNITS_EX
  /**
   * Unit code representing centimeters.
   */
  val cm: SizeUnit = UNITS_CM
  /**
   *   Unit code representing inches.
   */
  val inch: SizeUnit = UNITS_INCH
  /**
   *     Unit code representing millimeters.
   */
  val mm: SizeUnit = UNITS_MM

  /**
   *   unit code representing in percentage of the containing element defined by terminal.
   */
  private val percent: SizeUnit = UNITS_PERCENTAGE
  val % = percent
  /**
   *   Unit code representing picas (12 points).
   */
  val pi: SizeUnit = UNITS_PICAS
  /**
   *  Unit code representing pixels.
   */
  val px: SizeUnit = UNITS_PIXELS
  /**
   *  Unit code representing points
   */
  val pt: SizeUnit = UNITS_POINTS
}


trait Sizeable extends PeerProxy[com.vaadin.terminal.Sizeable] {
  import Units._
  final def sizeFull(): Unit = peer.setSizeFull

  final def sizeUndefined(): Unit = peer.setSizeUndefined()

  final def width: (Float, SizeUnit) = (peer.getWidth, peer.getWidthUnits)

  final def width_=(c: (Float, SizeUnit)): Unit = peer.setWidth(c._1, c._2)

  final def width_=(w: String): Unit = peer.setWidth(w)

  final def height: (Float, SizeUnit) = (peer.getHeight, peer.getHeightUnits)

  final def height_=(c: (Float, SizeUnit)): Unit = peer.setHeight(c._1, c._2)

  final def height_=(w: String): Unit = peer.setHeight(w)
}